package edu.unlam.progava.olivares.estrategias;
import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public class Cuadratica extends Estrategia {

	@Override
	public int obtenerMejorR2(List<Lanzamiento> lanzamientos) {

		double maximaDistancia = getDistanciaMaxima(lanzamientos);

		int[] diferencias = new int[(int) (Math.pow(maximaDistancia, 2))];
		for (int i = 0; i < diferencias.length; i++) {
			diferencias[i] = diferenciaPara(lanzamientos, i);
		}

		int mejorR2 = 0;
		for (int i = 0; i < diferencias.length; i++) {
			if (diferencias[i] > diferencias[mejorR2]) {
				mejorR2 = i;
			}
		}
		return mejorR2;
	}

	private int diferenciaPara(List<Lanzamiento> lanzamientos, int r2) {
		int diferencia = 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			if (lanzamiento.getDistancia() <= Math.sqrt(r2)) {
				diferencia += lanzamiento.esFavorable() ? 1 : -1;
			}
		}
		return diferencia;
	}
}
