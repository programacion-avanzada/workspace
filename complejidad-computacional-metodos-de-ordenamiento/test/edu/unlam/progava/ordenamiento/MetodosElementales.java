package edu.unlam.progava.ordenamiento;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.progava.ordenamiento.Estrategia;
import edu.unlam.progava.ordenamiento.Ordenadora;
import edu.unlam.progava.ordenamiento.elementales.PorBurbujeo;
import edu.unlam.progava.ordenamiento.elementales.PorInsercion;
import edu.unlam.progava.ordenamiento.elementales.PorSeleccion;

public class MetodosElementales {

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
			new PorSeleccion<Integer>(),
			new PorBurbujeo<Integer>(),
			new PorInsercion<Integer>()
		};

		for (Estrategia<Integer> estrategia : estrategias) {
			ordenadora.setEstrategia(estrategia);
			Assert.assertArrayEquals(ordenados, ordenadora.ordenar(elementos));
		}
	}

}
