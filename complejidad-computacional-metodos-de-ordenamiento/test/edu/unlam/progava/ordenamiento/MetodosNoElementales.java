package edu.unlam.progava.ordenamiento;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.progava.ordenamiento.noElementales.PorMergeSort;
import edu.unlam.progava.ordenamiento.noElementales.PorQuickSort;
import edu.unlam.progava.ordenamiento.noElementales.PorShellSort;

public class MetodosNoElementales {

	@Test
	public void pruebaAleatorios() {
		Integer[] elementos = { 1, 3, 2, 4, 0, -1, 5, 9, 6 };
		Integer[] ordenados = { -1, 0, 1, 2, 3, 4, 5, 6, 9 };

		run(elementos, ordenados);
	}
	
	@Test
	public void pruebaOrdenado() {
		Integer[] elementos = { -1, 0, 1, 2, 3, 4, 5, 6, 9 };
		Integer[] ordenados = { -1, 0, 1, 2, 3, 4, 5, 6, 9 };

		run(elementos, ordenados);
	}
	
	@Test
	public void pruebaInvertido() {
		Integer[] elementos = { 9, 6, 5, 4, 3, 2, 1, 0, -1 };
		Integer[] ordenados = { -1, 0, 1, 2, 3, 4, 5, 6, 9 };

		run(elementos, ordenados);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void run(Integer[] elementos, Integer[] ordenados) {
		Ordenadora<Integer> ordenadora = new Ordenadora<Integer>();

		Estrategia[] estrategias = { 
			new PorQuickSort<Integer>(),
			new PorMergeSort<Integer>(),
			new PorShellSort<Integer>()
		};

		for (Estrategia<Integer> estrategia : estrategias) {
			ordenadora.setEstrategia(estrategia);
			Assert.assertArrayEquals(ordenados, ordenadora.ordenar(elementos));
		}
	}

}
