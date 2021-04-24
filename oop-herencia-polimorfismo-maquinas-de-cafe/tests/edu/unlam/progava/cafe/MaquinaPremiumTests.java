package edu.unlam.progava.cafe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaquinaPremiumTests {

	@Test
	public void test() {
		MaquinaDeCafe maquina = new MaquinaPremium();
		assertTrue(maquina.servir().isLleno());
	}
	
	@Test
	public void test2() {
		MaquinaDeCafe maquina = new MaquinaPremium();
		for (int i = 0; i < 83; i++) {
			assertTrue(maquina.servir().isLleno());
		}
		assertNull(maquina.servir());
	}

}
