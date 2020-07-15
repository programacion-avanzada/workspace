package edu.unlam.progava.ordenamiento;

public abstract class Estrategia<T extends Comparable<T>> {

	public abstract T[] ordenar(final T[] arregloInmutable);

	protected void intercambiar(T[] arreglo, int i, int j) {
		T temporal = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = temporal;
	}

}
