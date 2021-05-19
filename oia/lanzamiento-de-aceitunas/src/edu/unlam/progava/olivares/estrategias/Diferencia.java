package edu.unlam.progava.olivares.estrategias;

import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public class Diferencia extends Estrategia {

	/**
	 * @CC O(lanzamientos + distanciaMaximaCentro)
	 * @SpaceComplexity distanciaMaximaCentro * 2 Bytes (size of short)
	 */
	@Override
	public int obtenerMejorR2(final List<Lanzamiento> lanzamientos) {
		short[] diferencias = new short[getDistanciaMaxima(lanzamientos) + 1];

		// Colocamos los puntos
		for (Lanzamiento lanzamiento : lanzamientos) {
			diferencias[lanzamiento.getDistanciaCuadrado()] += lanzamiento.esFavorable() ? 1 : -1;
		}

		// Arrastramos los resultados a todo el arreglo y obtenemos el más favorable
		int mejorR2 = 0;
		for (int i = 1; i < diferencias.length; i++) {
			diferencias[i] += diferencias[i - 1];
			if (diferencias[i] > diferencias[mejorR2]) {
				mejorR2 = i;
			}
		}

		return mejorR2;
	}
}
