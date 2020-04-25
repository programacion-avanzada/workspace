package edu.unlam.progava.oop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContadorTests {

	private Contador miContador;

	@Before
	public void setup() {
		miContador = new Contador();
	}

	@Test
	public void queIniciaEnCero() {
		Assert.assertEquals(0, miContador.mostrar());
	}

	@Test
	public void queCuentaUno() {
		miContador.contar();
		Assert.assertEquals(1, miContador.mostrar());
	}

	@Test
	public void queCuentaMil() {
		for (int i = 0; i < 1000; i++) {
			miContador.contar();
		}
		Assert.assertEquals(1000, miContador.mostrar());
	}

	@Test
	public void queCuentaHastaElMaximoEntero() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			miContador.contar();
		}
		Assert.assertEquals(Integer.MAX_VALUE, miContador.mostrar());
	}

	@Test
	public void queSeReinicia() {
		miContador.contar();
		Assert.assertEquals(1, miContador.mostrar());
		
		miContador.reiniciar();
		Assert.assertEquals(0, miContador.mostrar());
	}
}
