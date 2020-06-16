package edu.unlam.progava.ordenamiento.noelementales;

import java.util.Arrays;

import edu.unlam.progava.ordenamiento.Estrategia;

public class PorShellSort<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		int n = arreglo.length;

		for (int espacio = n / 2; espacio > 0; espacio /= 2) {
			for (int i = espacio; i < n; i += 1) {
				T temporal = arreglo[i];
				int j;
				for (j = i; j >= espacio && arreglo[j - espacio].compareTo(temporal) > 0; j -= espacio)
					arreglo[j] = arreglo[j - espacio];
				arreglo[j] = temporal;
			}
		}
		return arreglo;
	}
}
