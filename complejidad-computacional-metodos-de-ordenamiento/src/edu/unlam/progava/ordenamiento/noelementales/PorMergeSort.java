package edu.unlam.progava.ordenamiento.noelementales;

import java.lang.reflect.Array;
import java.util.Arrays;

import edu.unlam.progava.ordenamiento.Estrategia;

public class PorMergeSort<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		ordenar(arreglo, 0, arreglo.length - 1);
		return arreglo;
	}

	private void ordenar(T arreglo[], int limiteIzquierdo, int limiteDerecho) {
		if (limiteIzquierdo < limiteDerecho) {
			int puntoMedio = (limiteIzquierdo + limiteDerecho) / 2;

			ordenar(arreglo, limiteIzquierdo, puntoMedio);
			ordenar(arreglo, puntoMedio + 1, limiteDerecho);

			merge(arreglo, limiteIzquierdo, puntoMedio, limiteDerecho);
		}
	}

	@SuppressWarnings("unchecked")
	private void merge(T arreglo[], int limiteIzquierdo, int puntoMedio, int limiteDerecho) {
		int n1 = puntoMedio - limiteIzquierdo + 1;
		int n2 = limiteDerecho - puntoMedio;

		T[] arregloTemporalIzquierdo = (T[]) Array.newInstance(arreglo[0].getClass(), n1);
		T[] arregloTemporalDerecho = (T[]) Array.newInstance(arreglo[0].getClass(), n2);

		for (int i = 0; i < n1; ++i)
			arregloTemporalIzquierdo[i] = arreglo[limiteIzquierdo + i];
		for (int j = 0; j < n2; ++j)
			arregloTemporalDerecho[j] = arreglo[puntoMedio + 1 + j];

		int i = 0, j = 0;

		int k = limiteIzquierdo;
		while (i < n1 && j < n2) {
			if (arregloTemporalIzquierdo[i].compareTo(arregloTemporalDerecho[j]) < 0) {
				arreglo[k] = arregloTemporalIzquierdo[i];
				i++;
			} else {
				arreglo[k] = arregloTemporalDerecho[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arreglo[k] = arregloTemporalIzquierdo[i];
			i++;
			k++;
		}

		while (j < n2) {
			arreglo[k] = arregloTemporalDerecho[j];
			j++;
			k++;
		}
	}
}
