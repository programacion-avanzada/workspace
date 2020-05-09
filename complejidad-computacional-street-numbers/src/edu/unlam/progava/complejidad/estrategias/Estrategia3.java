package edu.unlam.progava.complejidad.estrategias;

public class Estrategia3 implements StreetNumbersStrategy {

	@Override
	public int alturaDeLaCasa(int ultimoNumero) {
		if (ultimoNumero < 3) {
			return -1;
		}

		double i = Math.sqrt((Math.pow(ultimoNumero, 2) + ultimoNumero) / 2);
		int entera = (int) i;
		if ((i - entera) == 0) {
			return (int) i;
		}

		return -1;
	}

	@Override
	public String toString() {
		return "Estrategia 3";
	}

}
