package edu.unlam.progava.pelotones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PelotonTest {

	private Unidad u1, u2, u3, u4;
	private Peloton p, pp;

	@Before
	public void setup() {
		u1 = new Unidad(new Punto(0, 0));
		u2 = new Unidad(new Punto(0, 1));
		u3 = new Unidad(new Punto(0, 2));
		
		p = new Peloton();
		p.agregar(u1);
		p.agregar(u2);
		p.agregar(u3);
		
		pp = new Peloton();
		pp.agregar(p);
		u4 = new Unidad(new Punto(-1, 2));
		pp.agregar(u4);
	}
	
	@Test
	public void queTodosSeMueven() {
		pp.moverse(3, -1.5);
		
		Assert.assertEquals(new Punto(3, -1.5), u1.getPosicion());
		Assert.assertEquals(new Punto(3, -0.5), u2.getPosicion());
		Assert.assertEquals(new Punto(3, 0.5), u3.getPosicion());
		Assert.assertEquals(new Punto(2, 0.5), u4.getPosicion());
	}
	
	@Test
	public void queTodosAtacan() {
		UnidadStub victima = new UnidadStub(new Punto(10, 10));
		Assert.assertEquals(0, victima.getAtaquesRecibidos());
		pp.atacar(victima);
		Assert.assertEquals(4, victima.getAtaquesRecibidos());
	}

}
