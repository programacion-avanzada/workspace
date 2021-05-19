package edu.unlam.progava.olivares.estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public class Cuadratica extends Estrategia {

	/**
	 * @CC O(n2)
	 */
	@Override
	public int obtenerMejorR2(final List<Lanzamiento> lanzamientos) {
		// Recorremos los lanzamientos y obtenemos el más favorable O(n)
		int mejorR2 = 0;
		int mejorAcu = 0;

		int acu = 0;
		int R2 = 0;

		for (int i = 0; i < lanzamientos.size() - 1; i++) {
			Lanzamiento lanzamientoDeReferencia = lanzamientos.get(i);
			R2 = lanzamientoDeReferencia.getDistanciaCuadrado();
			acu = lanzamientoDeReferencia.esFavorable() ? 1 : -1;
			for (int j = i; j < lanzamientos.size(); j++) {
				Lanzamiento lanzamientoActual = lanzamientos.get(j);
				if (lanzamientoActual.getDistanciaCuadrado() <= R2) {
					acu += lanzamientoActual.esFavorable() ? 1 : -1;
				}
			}
			if (acu > mejorAcu) {
				mejorAcu = acu;
				mejorR2 = R2;
			}
		}
		return mejorR2;
	}
}
