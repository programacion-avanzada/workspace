package edu.unlam.progava.complejidad.estrategias;

public class Estrategia1 implements StreetNumbersStrategy {

	@Override
	public int alturaDeLaCasa(int ultimoNumero) {
		if (ultimoNumero < 3) {
			return -1;
		}
		for (int i = 2; i <= ultimoNumero; i++) {
			int sumaIzquierda = 0;
			for (int j = 1; j < i; j++) {
				sumaIzquierda += j;
			}

			int sumaDerecha = 0;
			for (int k = i + 1; k <= ultimoNumero; k++) {
				sumaDerecha += k;
			}

			if (sumaDerecha == sumaIzquierda) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Estrategia 1";
	}

}
