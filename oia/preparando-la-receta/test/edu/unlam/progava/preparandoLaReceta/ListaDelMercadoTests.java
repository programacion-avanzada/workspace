package edu.unlam.progava.preparandoLaReceta;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class ListaDelMercadoTests {

	@Test
	public void enunciado() {
		Heladera heladera = new Heladera();
		for (String ingrediente : new String[] { "limon", "limon", "pan", "panceta" }) {
			heladera.add(ingrediente);
		}

		Receta receta = new Receta();
		for (String ingrediente : new String[] { "limon", "palometa", "choclo", "pan", "limon", "papa", "cordero",
				"papa" }) {
			receta.add(ingrediente);
		}

		Set<String> resultadoEsperado = new TreeSet<String>();
		for (String ingrediente : new String[] { "papa", "choclo", "cordero", "palometa" }) {
			resultadoEsperado.add(ingrediente);
		}

		assertEquals(resultadoEsperado, new ListaDelMercado().faltantes(heladera, receta));
	}

}
