package tests;

import org.junit.Assert;
import org.junit.Test;

import computando_patentes.Patente;

public class PatenteTests {
	@Test
	public void testPatente1995() {
		Patente p;

		p = new Patente("AAA001");
		Assert.assertEquals("AAB101", p.getPatenteSiguiente(1100));

		p = new Patente("AZZ999");
		Assert.assertEquals("BAA000", p.getPatenteSiguiente(1));

		p = new Patente("BBB222");
		Assert.assertEquals("CCC333", p.getPatenteSiguiente(703111));
	}

	@Test
	public void testPatente2016() {
		Patente p;

		p = new Patente("AA001AA");
		Assert.assertEquals("AA001BB", p.getPatenteSiguiente(27));

		p = new Patente("AZ999ZZ");
		Assert.assertEquals("BA000AA", p.getPatenteSiguiente(1));

		p = new Patente("BB222BB");
		Assert.assertEquals("CC333CC", p.getPatenteSiguiente(18327063));
	}
}
