package edu.unlam.progava.olivares.estrategias;

import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public class Lineal extends Estrategia {

	@Override
	public int obtenerMejorR2(List<Lanzamiento> lanzamientos) {

		double maximaDistancia = getDistanciaMaxima(lanzamientos);

		int[] diferencias = new int[(int) Math.ceil(Math.pow(maximaDistancia, 2)) + 1];

		// colocamos los puntos
		for (Lanzamiento lanzamiento : lanzamientos) {
			diferencias[(int) Math.ceil(Math.pow(lanzamiento.getDistancia(), 2))]
					+= lanzamiento.esFavorable() ? 1 : -1;
		}

		// arrastramos los resultados a todo el arreglo
		for (int i = 1; i < diferencias.length; i++) {
			diferencias[i] = diferencias[i - 1] + diferencias[i];
		}

		// obtenemos el más favorable, prefiriendo el primero que aparezca
		int mejorR2 = 0;
		for (int i = 0; i < diferencias.length; i++) {
			if (diferencias[i] > diferencias[mejorR2]) {
				mejorR2 = i;
			}
		}
		return mejorR2;
	}

}
