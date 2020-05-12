package edu.unlam.progava.complejidad.estrategias;

public class Estrategia3 implements StreetNumbersStrategy {

	@Override
	public int alturaDeLaCasa(int ultimoNumero) {
		if (ultimoNumero < 3) {
			return -1;
		}

		double i = Math.sqrt((ultimoNumero * ultimoNumero + ultimoNumero) / 2);
		if ((i % 1) == 0) {
			return (int) i;
		}

		return -1;
	}

	@Override
	public String toString() {
		return "Estrategia 3";
	}

}
