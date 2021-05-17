package edu.unlam.progava.olivares.estrategias;

import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public abstract class Estrategia {
	public abstract int obtenerMejorR2(List<Lanzamiento> lanzamientos);

	protected int getDistanciaMaxima(List<Lanzamiento> lanzamientos) {
		int maximaDistancia = 0;
		Lanzamiento lmax = null;
		for (Lanzamiento lanzamiento : lanzamientos) {
			if (lanzamiento.getDistanciaCuadrado() > maximaDistancia) {
				maximaDistancia = lanzamiento.getDistanciaCuadrado();
				lmax = lanzamiento;
			}
		}
		System.out.println(lmax.getDistanciaCuadrado());
		System.out.println(lmax.esFavorable());
		return maximaDistancia;
	}
}
