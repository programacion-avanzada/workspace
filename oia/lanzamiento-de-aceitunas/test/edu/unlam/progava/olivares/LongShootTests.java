package edu.unlam.progava.olivares;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.progava.olivares.estrategias.Diferencia;

public class LongShootTests {
	private Partido partido;

	@Before
	public void setUp() {
		partido = new Partido();

		for (int i = 0; i < 500000; i++) {
			partido.agregar(new Lanzamiento(1, (int) Math.sqrt(i * 1000 - 1)));
			partido.agregar(new Lanzamiento(-1, (int) Math.sqrt(i * 1000 + 1)));
		}
	}

	@Test
	public void estrategiaNlogN() {
		Assert.assertEquals(1, partido.obtenerMejorR2());
	}

	@Test
	public void estrategiaDiferencia() {
		partido.setEstrategia(new Diferencia());
		Assert.assertEquals(1, partido.obtenerMejorR2());
	}
}
