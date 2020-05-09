package edu.unlam.progava.complejidad.estrategias;

public class Estrategia2 implements StreetNumbersStrategy {

	@Override
	public int alturaDeLaCasa(int ultimoNumero) {
		if (ultimoNumero < 3) {
			return -1;
		}

		for (int i = 1; i <= ultimoNumero; i++) {
			int sumaIzquierda = i * (i - 1) / 2;
			int sumaDerecha = (ultimoNumero * (ultimoNumero + 1) / 2 - i * (i + 1) / 2);
			if (sumaDerecha == sumaIzquierda)
				return i;

		}
		return -1;
	}

	@Override
	public String toString() {
		return "Estrategia 2";
	}

}
