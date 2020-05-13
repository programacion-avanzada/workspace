package edu.unlam.progava.complejidadComputacional;

import java.util.Arrays;

public class PorSeleccion<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		
		T menor;
		int i, j, posicionDelMenor;
		
		for (i = 0; i < arreglo.length - 1; i++) {
			menor = arreglo[i];
			posicionDelMenor = i;
			for (j = i + 1; j < arreglo.length; j++) {
				if (arreglo[j].compareTo(menor) < 0) {
					menor = arreglo[j];
					posicionDelMenor = j;
				}
			}
			if (posicionDelMenor != i) {
				intercambiar(arreglo, i, posicionDelMenor);
			}
		}
		return arreglo;
	}

}
