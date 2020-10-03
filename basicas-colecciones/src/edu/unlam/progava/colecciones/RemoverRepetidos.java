package edu.unlam.progava.colecciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class RemoverRepetidos {

	// Si bien se utiliza el mecanismo de los tests, estos son ejemplos de uso.
	// Sólo para mejorar la legibilidad se agregan las aserciones.
		
	@Test
	public void ejemploDeEliminarRepetidos() {
		
		// Supongamos que tenemos una lista de MVPs en un torneo de fútbol
		
		String[] mvps = { "Oliver", "Tom", "Benji", "Steve", "Steve", "Oliver",
				"Oliver", "Bruce", "Benji", "Tom", "Oliver", "Steve" };
		
		// Si quisiéramos eliminar repetidos de esa colección, podríamos hacerlo
		// caso por caso, o utilizar las bondades de la clase Set
		
		// Debemos convertir el array nativo a una lista, mediante la utilidad
		// Arrays.asList()
		Set<String> conjuntoSinRepetir = new TreeSet<String>(Arrays.asList(mvps));
		
		// Si lo volvemos a necesitar dentro de una lista, podemos hacer el
		// pasaje inverso.
		
		List<String> listaSinRepetir = new LinkedList<String>(conjuntoSinRepetir);
		
		// Y verificamos que tiene los cinco elementos que necesitamos
		assertEquals(5, listaSinRepetir.size());
		
		assertTrue(listaSinRepetir.contains("Benji"));
		assertTrue(listaSinRepetir.contains("Bruce"));
		assertTrue(listaSinRepetir.contains("Oliver"));
		assertTrue(listaSinRepetir.contains("Steve"));
		assertTrue(listaSinRepetir.contains("Tom"));
		
		// y está ordenado
		assertEquals("Benji", listaSinRepetir.get(0));
		assertEquals("Bruce", listaSinRepetir.get(1));
		assertEquals("Oliver", listaSinRepetir.get(2));
		assertEquals("Steve", listaSinRepetir.get(3));
		assertEquals("Tom", listaSinRepetir.get(4));
		
	}
}
