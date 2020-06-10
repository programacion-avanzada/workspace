package edu.unlam.progava.olivares;

import java.util.LinkedList;
import java.util.List;

import edu.unlam.progava.olivares.estrategias.Estrategia;
import edu.unlam.progava.olivares.estrategias.Cuadratica;

public class Partido {

	private List<Lanzamiento> lanzamientos = new LinkedList<Lanzamiento>();
	private Estrategia estrategia = new Cuadratica();

	public boolean agregar(Lanzamiento lanzamiento) {
		return lanzamientos.add(lanzamiento);
	}

	public int obtenerMejorR2() {
		return estrategia.obtenerMejorR2(this.lanzamientos);
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
}
