package edu.unlam.progava.sumo;

import org.junit.Assert;
import org.junit.Test;

public class LuchadorTests {

	@Test
	public void queDominaEnAmbasMedidas() {
		Luchador uno = new Luchador(300, 1500);
		Luchador dos = new Luchador(290, 1450);

		Assert.assertTrue(uno.domina(dos));
		Assert.assertFalse(dos.domina(uno));
	}

	@Test
	public void queDominaEnAlturaSolamente() {
		Luchador uno = new Luchador(300, 1500);
		Luchador dos = new Luchador(300, 1450);

		Assert.assertTrue(uno.domina(dos));
		Assert.assertFalse(dos.domina(uno));
	}

	@Test
	public void queDominaEnPesoSolamente() {
		Luchador uno = new Luchador(300, 1500);
		Luchador dos = new Luchador(290, 1500);

		Assert.assertTrue(uno.domina(dos));
		Assert.assertFalse(dos.domina(uno));
	}

	@Test
	public void queDominaEnPesoPeroLoDominanEnAltura() {
		Luchador uno = new Luchador(300, 1500);
		Luchador dos = new Luchador(290, 1550);

		Assert.assertFalse(uno.domina(dos));
		Assert.assertFalse(dos.domina(uno));
	}

	@Test
	public void queDominaEnPesoAlturaLoDominanEnPeso() {
		Luchador uno = new Luchador(300, 1500);
		Luchador dos = new Luchador(310, 1450);

		Assert.assertFalse(uno.domina(dos));
		Assert.assertFalse(dos.domina(uno));
	}
}
