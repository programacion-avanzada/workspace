package edu.unlam.progava.cafe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaquinaEconomicaTests {

	@Test
	public void test() {
		MaquinaDeCafe maquina = new MaquinaEconomica();
		assertTrue(maquina.servir().isLleno());
	}
	
	@Test
	public void test2() {
		MaquinaDeCafe maquina = new MaquinaEconomica();
		for (int i = 0; i < 249; i++) {
			assertTrue(maquina.servir().isLleno());
		}
		assertNull(maquina.servir());
	}

}
