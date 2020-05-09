package edu.unlam.progava.complejidad;

import java.util.LinkedList;
import java.util.List;

import edu.unlam.progava.complejidad.estrategias.*;
import edu.unlam.progava.complejidad.utils.Tupla;

public class App {

	public static void main(String[] args) {
		StreetNumbers numbers = new StreetNumbers();
		StreetNumbersStrategy[] estrategias = { new Estrategia1(), new Estrategia2(), new Estrategia3() };

		for (StreetNumbersStrategy estrategia : estrategias) {
			numbers.setEstrategia(estrategia);
			run(numbers);
			System.out.println("---------------------------------");
		}

	}

	private static void run(StreetNumbers numbers) {
		List<Tupla<Integer, Integer>> resultados = new LinkedList<Tupla<Integer, Integer>>();
		int altura;
		long tiempoInicio = System.nanoTime();
		for (int ultimoNumero = 1; ultimoNumero < Integer.MAX_VALUE && resultados.size() < 4; ultimoNumero++) {
			altura = numbers.alturaDeLaCasa(ultimoNumero);
			if (altura != -1) {
				resultados.add(new Tupla<Integer, Integer>(altura, ultimoNumero));
			}
		}
		long tiempoFinal = System.nanoTime();
		System.out.println("Estrategia utilizada: " + numbers.getEstrategia());
		System.out.println("Reporte de tiempo: " + (tiempoFinal - tiempoInicio) / 1e6 + " ms");
		System.out.println("Resultados: ");
		for (Tupla<Integer, Integer> alturaYUltimo : resultados) {
			System.out.println(alturaYUltimo);
		}
	}

}
