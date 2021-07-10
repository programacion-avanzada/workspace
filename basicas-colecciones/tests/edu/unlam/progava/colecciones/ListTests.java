package edu.unlam.progava.colecciones;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTests {

	private List<String> lista;

	// Documentación:
	// https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/LinkedList.java
	// https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/ArrayList.java

	@Before
	public void setUp() {
		lista = new ArrayList<String>();
		// ^ también podría ser LinkedList

		lista.add("Virginia");
		lista.add("Salomón");
		lista.add("Ernesto");
		lista.add("Carmela");
	}

	@Test
	public void queIniciaVacia() {
		lista = new ArrayList<String>();
		Assert.assertEquals(0, lista.size());
	}

	@Test
	public void queTieneElementos() {
		Assert.assertEquals(4, lista.size());
	}

	@Test
	public void queContieneElemento() {
		Assert.assertTrue(lista.contains("Salomón"));
		Assert.assertFalse(lista.contains("Patricio"));
	}

	@Test
	public void queAgregoPosicionalmente() {
		Assert.assertEquals("Salomón", lista.get(1));
		lista.add(1, "Patricio");
		Assert.assertEquals("Patricio", lista.get(1));
	}
	
	@Test
	public void queRemuevoPosicionalmente() {
		Assert.assertEquals("Salomón", lista.get(1));
		Assert.assertEquals(4, lista.size());
		
		lista.remove(1);
		
		Assert.assertEquals("Ernesto", lista.get(1));
		Assert.assertEquals(3, lista.size());
	}
	
	@Test
	public void queRemuevoPorIgualdad() {
		Assert.assertEquals("Salomón", lista.get(1));
		Assert.assertEquals(4, lista.size());
		
		lista.remove("Salomón");
		
		Assert.assertEquals("Ernesto", lista.get(1));
		Assert.assertEquals(3, lista.size());
	}
	
	@Test
	public void queRemueveLaPrimeraOcurrencia() {
		Assert.assertTrue(lista.contains("Salomón"));
		lista.add("Salomón");

		Assert.assertTrue(lista.contains("Salomón"));
		
		lista.remove("Salomón");

		Assert.assertTrue(lista.contains("Salomón"));
	}
	
	@Test
	public void queReemplazoPosicionalmente() {
		Assert.assertEquals("Salomón", lista.get(1));
		Assert.assertEquals(4, lista.size());
		
		lista.set(1, "Patricio");
		
		Assert.assertEquals("Patricio", lista.get(1));
		Assert.assertEquals(4, lista.size());
	}

	@Test
	public void queSiAgregoPosicionalmenteSeExpande() {
		Assert.assertEquals(4, lista.size());
		lista.add(1, "Patricio");
		Assert.assertEquals(5, lista.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void queNoPuedoAgregarPosicionalmentePorFueraDelTama�() {
		Assert.assertEquals(4, lista.size());
		lista.add(5, "Patricio");
	}

	@Test
	public void quePuedoRecorrerlaEnOrden() {
		String nombres = "";
		for (String nombre : lista) {
			nombres += nombre + " ";
		}
		Assert.assertEquals("Virginia Salomón Ernesto Carmela ", nombres);
	}
}
