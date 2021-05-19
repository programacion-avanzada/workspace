package edu.unlam.progava.olivares.estrategias;

import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public abstract class Estrategia {
	public abstract int obtenerMejorR2(final List<Lanzamiento> lanzamientos);

	protected int getDistanciaMaxima(final List<Lanzamiento> lanzamientos) {
		int maximaDistancia = 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			if (lanzamiento.getDistanciaCuadrado() > maximaDistancia) {
				maximaDistancia = lanzamiento.getDistanciaCuadrado();
			}
		}
		return maximaDistancia;
	}
}
