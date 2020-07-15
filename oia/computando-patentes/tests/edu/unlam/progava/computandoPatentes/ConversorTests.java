package edu.unlam.progava.computandoPatentes;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.progava.patentes.Patente;

public class ConversorTests {
	
	@Test
	public void testPatente1995() {
		Patente patente;

		patente = new Patente("AAA001");
		Assert.assertEquals(new Patente("AAB101"), patente.getPatenteSiguiente(1100));

		patente = new Patente("AZZ999");
		Assert.assertEquals(new Patente("BAA000"), patente.getPatenteSiguiente(1));

		patente = new Patente("BBB222");
		Assert.assertEquals(new Patente("CCC333"), patente.getPatenteSiguiente(703111));
	}

	@Test
	public void testPatente2016() {
		Patente patente;

		patente = new Patente("AA001AA");
		Assert.assertEquals(new Patente("AA001BB"), patente.getPatenteSiguiente(27));

		patente = new Patente("AZ999ZZ");
		Assert.assertEquals(new Patente("BA000AA"), patente.getPatenteSiguiente(1));

		patente = new Patente("BB222BB");
		Assert.assertEquals(new Patente("CC333CC"), patente.getPatenteSiguiente(18327063));
	}
}
