package practica2;
import java.util.Arrays;
import java.util.Random;

public class OperArreglos {
	static void inicializarArreglo(int[] arreglo, int n){
		Random azar = new Random();
		int i;
		for(i = 0; i < arreglo.length; i++){
			arreglo[i] = azar.nextInt(n);
		}
	}
	static void imprimir(int [] arreglo){
		System.out.println(Arrays.toString(arreglo));
	}
}

