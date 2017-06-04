package practica2;
public class SumarArreglo extends Thread{
	static int N = 1;
	static int HILOS = 1;
	static int [] arreglo = null;
	private int id = -1;

	SumarArreglo(int id){
	    this.id = id;
	}
	public void run(){
	    int i, suma = 0;
	    int tam = arreglo.length/HILOS;
	    int resto = (arreglo.length%HILOS);
	    int ini = (id * tam);
	    int fin = ini + tam;
	    for(i = ini; i < fin; i++){
	        suma = suma + arreglo[i];
	    }
	    if(resto > id){
	        suma = suma + arreglo[(arreglo.length - 1) - id];
	    }
	    System.out.println("Hilo " +id+ "PID: " +this.getId()+ " Suma Local: " +suma);
	}



	public static void main(String[] arg) {
		int i;
		Thread[] trabajadores = null;
		try{
			N = Integer.parseInt(arg[0]);
			HILOS = Integer.parseInt(arg[1]);
		}    catch(NumberFormatException e){
			System.out.println("Error: No es posible convertir a entero");
			System.exit(0);
		}
		arreglo = new int[N];
		trabajadores = new Thread[HILOS];
		OperArreglos.inicializarArreglo(arreglo, 100);
		OperArreglos.imprimir(arreglo);
		
		for(i = 0; i < HILOS; i++){
			trabajadores[i] = new SumarArreglo(i);
			trabajadores[i].start();
		}
		for(i = 0; i < HILOS; i++){
			try{
				trabajadores[i].join();
			}    catch(InterruptedException e){
				System.out.println("Error: en la espera del hilo");
			}
		}
	}

}
