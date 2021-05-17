package edu.unlam.progava.cafe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaquinaEstafadoraTests {

	@Test
	public void test() {
		MaquinaDeCafe maquina = new MaquinaEstafadora();
		assertTrue(maquina.servir().isLleno());
		assertFalse(maquina.servir().isLleno());
	}

	@Test
	public void test2() {
		MaquinaDeCafe maquina = new MaquinaEstafadora();
		for (int i = 0; i < 165; i++) {
			if (i % 2 == 0) {
				assertTrue(maquina.servir().isLleno());
			} else {
				assertFalse(maquina.servir().isLleno());
			}
		}
		assertNull(maquina.servir());
	}

}
