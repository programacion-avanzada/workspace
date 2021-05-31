package edu.unlam.progava.olivares;

public class Lanzamiento {
	private int distanciaCuadrada;
	private boolean favorable;

	public Lanzamiento(int x, int y) {
		if (x == 0) {
			throw new LanzamientoNoValido("No puede aterrizar sobre la red");
		}
		distanciaCuadrada = x * x + y * y;
		favorable = x > 0;
	}

	public int getDistanciaCuadrado() {
		return distanciaCuadrada;
	}

	public boolean esFavorable() {
		return favorable;
	}
}
