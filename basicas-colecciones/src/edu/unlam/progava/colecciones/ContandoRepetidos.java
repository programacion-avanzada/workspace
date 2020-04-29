package edu.unlam.progava.colecciones;

import java.util.HashMap;
import java.util.Map;

public class ContandoRepetidos {

	public static void main(String[] args) {
		
		// Contamos la cantidad de veces que ganaron el campeonato
		
		String[] mvps = { "Oliver", "Tom", "Benji", "Steve", "Steve",
				"Oliver", "Oliver", "Bruce", "Benji", "Tom", "Oliver",
				"Steve" };
		
		Map<String, Integer> cuenta = new HashMap<String, Integer>();
		
		for (String nombre : mvps) {
			cuenta.put(nombre, cuenta.getOrDefault(nombre, 0) + 1);
		}
		
		System.out.println(cuenta);
	}

}
