package edu.unlam.progava.ordenamiento.noElementales;

import java.util.Arrays;

import edu.unlam.progava.ordenamiento.Estrategia;

public class PorQuickSort<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		ordenar(arreglo, 0, arreglo.length - 1);
		return arreglo;
	}

	private void ordenar(T arreglo[], int inferior, int superior) {
		if (inferior < superior) {
			int pivot = partition(arreglo, inferior, superior);

			ordenar(arreglo, inferior, pivot - 1);
			ordenar(arreglo, pivot + 1, superior);
		}
	}

	private int partition(T arreglo[], int inferior, int superior) {
		T pivot = arreglo[superior];
		int i = (inferior - 1);
		for (int j = inferior; j < superior; j++) {
			if (arreglo[j].compareTo(pivot) < 0) {
				i++;
				intercambiar(arreglo, i, j);
			}
		}
		intercambiar(arreglo, i + 1, superior);

		return i + 1;
	}
}
