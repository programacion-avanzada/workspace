package edu.unlam.progava.sumo;

import org.junit.Assert;
import org.junit.Test;

public class TorneoTests {

	@Test
	public void enunciado() {

		Torneo torneo = new Torneo();

		torneo.agregar(new Luchador(300, 1500));
		torneo.agregar(new Luchador(320, 1500));
		torneo.agregar(new Luchador(299, 1580));
		torneo.agregar(new Luchador(330, 1690));
		torneo.agregar(new Luchador(330, 1540));
		torneo.agregar(new Luchador(339, 1500));
		torneo.agregar(new Luchador(298, 1700));
		torneo.agregar(new Luchador(344, 1570));
		torneo.agregar(new Luchador(276, 1678));
		torneo.agregar(new Luchador(289, 1499));

		Assert.assertArrayEquals(new int[] { 1, 2, 1, 6, 3, 3, 2, 5, 0, 0 },
				torneo.dominaciones());

	}

}
