package edu.unlam.progava.colecciones;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetTests {

	private Set<String> conjunto;
	
	// Documentación:
	// https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/TreeSet.java
	
	@Before
	public void setUp() {
		conjunto = new TreeSet<String>();
		
		conjunto.add("Lenny");
		conjunto.add("Carl");
		conjunto.add("Homer");
		conjunto.add("Wiggum");
	}
	
	@Test
	public void queIniciaVacio() {
		conjunto = new TreeSet<String>();
		Assert.assertEquals(0, conjunto.size());
	}
	
	@Test
	public void queTieneElementos() {
		Assert.assertEquals(4, conjunto.size());
	}
	
	@Test
	public void queContieneElemento() {
		Assert.assertTrue(conjunto.contains("Homer"));
		Assert.assertFalse(conjunto.contains("Apu"));
	}
	
	@Test
	public void queRemueveElemento() {
		Assert.assertTrue(conjunto.contains("Homer"));
		conjunto.remove("Homer");
		Assert.assertFalse(conjunto.contains("Homer"));
	}
	
	@Test
	public void queNoAdmiteRepetidos() {
		Assert.assertEquals(4, conjunto.size());
		conjunto.add("Homer");
		Assert.assertEquals(4, conjunto.size());
	}
	
	@Test
	public void quePuedoRecorrerlaYTieneOrdenNatural() {
		String nombres = "";
		for (String nombre : conjunto) {
			nombres += nombre + " ";
		}
		Assert.assertEquals("Carl Homer Lenny Wiggum ", nombres);
	}
	
	@Test
	public void queTieneOrdenInverso() {
		conjunto = new TreeSet<String>(new StringEnOrdenInverso());
		conjunto.add("Lenny");
		conjunto.add("Carl");
		conjunto.add("Homer");
		conjunto.add("Wiggum");
	
		String nombres = "";
		for (String nombre : conjunto) {
			nombres += nombre + " ";
		}
		Assert.assertEquals("Wiggum Lenny Homer Carl ", nombres);
	}	
}
