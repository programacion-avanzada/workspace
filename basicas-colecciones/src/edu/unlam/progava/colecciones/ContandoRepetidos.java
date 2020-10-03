package edu.unlam.progava.colecciones;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContandoRepetidos {

	// Si bien se utiliza el mecanismo de los tests, estos son ejemplos de uso.
	// Sólo para mejorar la legibilidad se agregan las aserciones.

	@Test
	public void ejemploDeContador() {

		// Supongamos que tenemos una lista de MVPs en un torneo de fútbol

		String[] mvps = { "Oliver", "Tom", "Benji", "Steve", "Steve", "Oliver",
				"Oliver", "Bruce", "Benji", "Tom", "Oliver", "Steve" };

		// Si quisiéramos saber cuántas veces fue nombrado MVP cada uno,
		// podríamos contar de la siguiente manera

		Map<String, Integer> cuenta = new HashMap<String, Integer>();

		for (String nombre : mvps) {
			// getOrDefault nos ayuda a evitar preguntar por nulos para
			// los valores no existentes
			cuenta.put(nombre, cuenta.getOrDefault(nombre, 0) + 1);
			
			// opción rústica
//			int cant;
//			if (!cuenta.containsKey(nombre)) {
//				cant = 1;
//			} else {
//				cant = cuenta.get(nombre) + 1;
//			}
//			cuenta.put(nombre, cant);
		}

		assertEquals(1, cuenta.get("Bruce").intValue());
		assertEquals(2, cuenta.get("Benji").intValue());
		assertEquals(4, cuenta.get("Oliver").intValue());
		assertEquals(3, cuenta.get("Steve").intValue());
		assertEquals(2, cuenta.get("Tom").intValue());
	}

}
