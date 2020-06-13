package edu.unlam.progava.pelotones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PelotonTest {

	private Unidad unidad1;
	private Unidad unidad2;
	private Unidad unidad3;
	private Unidad unidad4;
	private Peloton pelotonDePelotones;

	@Before
	public void setUp() {
		unidad1 = new Unidad(new Punto(0, 0));
		unidad2 = new Unidad(new Punto(0, 1));
		unidad3 = new Unidad(new Punto(0, 2));
		
		Peloton peloton = new Peloton();
		peloton.agregar(unidad1);
		peloton.agregar(unidad2);
		peloton.agregar(unidad3);
		
		pelotonDePelotones = new Peloton();
		pelotonDePelotones.agregar(peloton);
		unidad4 = new Unidad(new Punto(-1, 2));
		pelotonDePelotones.agregar(unidad4);
	}
	
	@Test
	public void queTodosSeMueven() {
		pelotonDePelotones.moverse(3, -1.5);
		
		Assert.assertEquals(new Punto(3, -1.5), unidad1.getPosicion());
		Assert.assertEquals(new Punto(3, -0.5), unidad2.getPosicion());
		Assert.assertEquals(new Punto(3, 0.5), unidad3.getPosicion());
		Assert.assertEquals(new Punto(2, 0.5), unidad4.getPosicion());
	}
	
	@Test
	public void queTodosAtacan() {
		UnidadStub victima = new UnidadStub(new Punto(10, 10));
		Assert.assertEquals(0, victima.getAtaquesRecibidos());
		pelotonDePelotones.atacar(victima);
		Assert.assertEquals(4, victima.getAtaquesRecibidos());
	}

}
