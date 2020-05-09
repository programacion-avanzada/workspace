package edu.unlam.progava.complejidad.utils;

public class Tupla<S1, S2> {

	private S1 x;
	private S2 y;

	public Tupla(S1 x, S2 y) {
		super();
		this.x = x;
		this.y = y;
	}

	public S1 getX() {
		return x;
	}

	public S2 getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

}
