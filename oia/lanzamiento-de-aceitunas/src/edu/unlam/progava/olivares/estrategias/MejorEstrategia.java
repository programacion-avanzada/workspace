package edu.unlam.progava.olivares.estrategias;

import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public class MejorEstrategia extends Estrategia {

	@Override
	public int obtenerMejorR2(List<Lanzamiento> lanzamientos) {
		Estrategia estrategia;
		int cantidad = lanzamientos.size();
		int distanciaMaxima = getDistanciaMaxima(lanzamientos);
		if (cantidad + distanciaMaxima < cantidad * Math.log(cantidad)) {
			estrategia = new Diferencia();
		} else {
			estrategia = new NlogN();
		}
		return estrategia.obtenerMejorR2(lanzamientos);
	}

}
