package edu.unlam.progava.olivares;

public class Lanzamiento {

	private int x;
	private int y;

	public Lanzamiento(int x, int y) {
		if (x == 0) {
			throw new LanzamientoNoValido("No puede aterrizar sobre la red");
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
