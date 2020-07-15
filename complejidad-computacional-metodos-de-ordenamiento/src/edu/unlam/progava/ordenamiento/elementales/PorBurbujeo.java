package edu.unlam.progava.ordenamiento.elementales;

import java.util.Arrays;

import edu.unlam.progava.ordenamiento.Estrategia;

public class PorBurbujeo<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);

		boolean huboCambio = false;
		do {
			huboCambio = false;
			for (int i = 0; i < arreglo.length - 1; i++) {
				if (arreglo[i].compareTo(arreglo[i + 1]) > 0) {
					intercambiar(arreglo, i, i + 1);
					huboCambio = true;
				}
			}
		} while (huboCambio);

		return arreglo;
	}

}
