package edu.unlam.progava.colecciones;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapaTests {

	Map<String, String> capitalesPorPais;

	// Documentación:
	// https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/HashMap.java

	@Before
	public void setup() {
		capitalesPorPais = new HashMap<String, String>();

		capitalesPorPais.put("Uruguay", "Montevideo");
		capitalesPorPais.put("Chile", "Santiago");
		capitalesPorPais.put("Francia", "Paris");
		capitalesPorPais.put("Italia", "Roma");
	}

	@Test
	public void queIniciaVacia() {
		capitalesPorPais = new HashMap<String, String>();
		Assert.assertEquals(0, capitalesPorPais.size());
	}

	@Test
	public void queTieneElementos() {
		Assert.assertEquals(4, capitalesPorPais.size());
	}

	@Test
	public void queContieneElemento() {
		Assert.assertTrue(capitalesPorPais.containsKey("Uruguay"));
		Assert.assertFalse(capitalesPorPais.containsKey("Irlanda"));
	}

	@Test
	public void queAlNoContenerDevuelveNulo() {
		// ¡Cuidado! Este comportamiento no es deseado,
		// deberemos lidiar con los nulos.
		Assert.assertNull(capitalesPorPais.get("Irlanda"));
	}

	@Test
	public void queAlNoContenerDevuelveDefault() {
		// Alternativa para subsanar el caso del test anterior
		Assert.assertEquals("Capital genérica",
				capitalesPorPais.getOrDefault("Irlanda", "Capital genérica"));
	}

	@Test
	public void queSobreescribeValoresParaMismaClave() {
		Assert.assertEquals("Santiago", capitalesPorPais.get("Chile"));
		capitalesPorPais.put("Chile", "Santiago de Chile");
		Assert.assertEquals("Santiago de Chile", capitalesPorPais.get("Chile"));
	}

	@Test
	public void queObtengoClavesComoSet() {
		Set<String> expected = new TreeSet<String>();
		expected.add("Chile");
		expected.add("Francia");
		expected.add("Italia");
		expected.add("Uruguay");

		Assert.assertEquals(expected, capitalesPorPais.keySet());
	}

	@Test
	public void queObtengoValoresComoList() {
		Collection<String> expected = new LinkedList<String>();
		expected.add("Montevideo");
		expected.add("Santiago");
		expected.add("Roma");
		expected.add("Paris");

		// No podemos verificar el orden de los elementos.
		// Verificamos la igualdad de colecciones.
		// Matemáticamente: A ⊆ B && B ⊆ A ⭢ A = B
		Assert.assertTrue(expected.containsAll(capitalesPorPais.values()));
		Assert.assertTrue(capitalesPorPais.values().containsAll(expected));
		// Y dado que podría haber repetidos, debemos verificar tamaños
		Assert.assertEquals(expected.size(), capitalesPorPais.values().size());
	}

	@Test
	public void queRecorroPorClaves() {
		String capitales = "";
		for (String pais : capitalesPorPais.keySet()) {
			capitales += capitalesPorPais.get(pais) + " ";
		}
		Assert.assertEquals("Montevideo Paris Santiago Roma ", capitales);
	}
}
