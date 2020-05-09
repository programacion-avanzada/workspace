package edu.unlam.progava.complejidad;

import edu.unlam.progava.complejidad.estrategias.Estrategia1;
import edu.unlam.progava.complejidad.estrategias.StreetNumbersStrategy;

public class StreetNumbers {

	private StreetNumbersStrategy estrategia = new Estrategia1();

	public StreetNumbersStrategy getEstrategia() {
		return this.estrategia;
	}

	public void setEstrategia(StreetNumbersStrategy estrategia) {
		this.estrategia = estrategia;
	}

	public int alturaDeLaCasa(int ultimoNumero) {
		return estrategia.alturaDeLaCasa(ultimoNumero);
	}

}
