package edu.unlam.progava.olivares;

public class Lanzamiento {

	private int x, y;

	public Lanzamiento(int x, int y) {
		if (x == 0) {
			throw new RuntimeException("Dato no válido, caso improcesable");
		}
		this.x = x;
		this.y = y;
	}

	public double getDistancia() {
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

	public boolean esFavorable() {
		return this.x > 0;
	}
}
