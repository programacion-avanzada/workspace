package tests;

import org.junit.Assert;
import org.junit.Test;

import computandoPatentes.Patente;

public class PatenteTests {
	@Test
	public void testPatente1995() {
		Patente patente;

		patente = new Patente("AAA001");
		Assert.assertEquals("AAB101", patente.getPatenteSiguiente(1100));

		patente = new Patente("AZZ999");
		Assert.assertEquals("BAA000", patente.getPatenteSiguiente(1));

		patente = new Patente("BBB222");
		Assert.assertEquals("CCC333", patente.getPatenteSiguiente(703111));
	}

	@Test
	public void testPatente2016() {
		Patente patente;

		patente = new Patente("AA001AA");
		Assert.assertEquals("AA001BB", patente.getPatenteSiguiente(27));

		patente = new Patente("AZ999ZZ");
		Assert.assertEquals("BA000AA", patente.getPatenteSiguiente(1));

		patente = new Patente("BB222BB");
		Assert.assertEquals("CC333CC", patente.getPatenteSiguiente(18327063));
	}
}
