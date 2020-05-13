package edu.unlam.progava.complejidadComputacional;

import java.util.Arrays;

public class PorInsercion<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);

		for (int i = 1; i < arreglo.length; i++) {
			T valorActual = arreglo[i];
			int j = i - 1;
			while (j >= 0 && arreglo[j].compareTo(valorActual) > 0) {
				arreglo[j + 1] = arreglo[j];
				j = j - 1;
			}
			arreglo[j + 1] = valorActual;
		}

		return arreglo;
	}

}
