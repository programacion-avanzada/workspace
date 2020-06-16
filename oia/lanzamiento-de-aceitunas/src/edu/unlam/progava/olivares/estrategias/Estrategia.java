package edu.unlam.progava.olivares.estrategias;
import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public abstract class Estrategia {
	public abstract int obtenerMejorR2(List<Lanzamiento> lanzamientos);

	protected double getDistanciaMaxima(List<Lanzamiento> lanzamientos) {
		double maximaDistancia = 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			maximaDistancia = Math.max(maximaDistancia, lanzamiento.getDistancia());
		}
		return maximaDistancia;
	}
}
