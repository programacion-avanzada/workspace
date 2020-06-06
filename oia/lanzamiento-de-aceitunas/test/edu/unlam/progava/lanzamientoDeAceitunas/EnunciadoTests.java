package edu.unlam.progava.lanzamientoDeAceitunas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.progava.lanzamientoDeAceitunas.estrategias.EstrategiaLineal;

public class EnunciadoTests {

	private Partido partido;

	@Before
	public void setup() {
		partido = new Partido();

		partido.agregar(new Lanzamiento(9, 3));
		partido.agregar(new Lanzamiento(6, 1));
		partido.agregar(new Lanzamiento(9, 8));
		partido.agregar(new Lanzamiento(-1, -2));
		partido.agregar(new Lanzamiento(8, -9));
		partido.agregar(new Lanzamiento(-2, 10));
		partido.agregar(new Lanzamiento(5, -8));
		partido.agregar(new Lanzamiento(-5, 8));
		partido.agregar(new Lanzamiento(-10, 9));
		partido.agregar(new Lanzamiento(-1, -10));
	}

	@Test
	public void estrategiaCuadratica() {
		Assert.assertEquals(90, partido.obtenerMejorR2());
	}

	@Test
	public void estrategiaLineal() {
		partido.setEstrategia(new EstrategiaLineal());
		Assert.assertEquals(90, partido.obtenerMejorR2());
	}
}
