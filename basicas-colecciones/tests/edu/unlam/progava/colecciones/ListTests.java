package edu.unlam.progava.colecciones;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTests {

	List<String> lista;
	
	@Before
	public void setup() {
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
	public void queSiAgregoPosicionalmenteSeExpande() {
		Assert.assertEquals(4, lista.size());
		lista.add(1, "Patricio");
		Assert.assertEquals(5, lista.size());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void queNoPuedoAgregarPosicionalmentePorFueraDelTamaño() {
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
