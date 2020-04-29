package edu.unlam.progava.colecciones;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetTests {

	Set<String> conjunto;
	
	@Before
	public void setup() {
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
}
