package edu.unlam.progava.olivares;

public class LanzamientoNoValido extends RuntimeException {

	private static final long serialVersionUID = 7763324240983015815L;

	public LanzamientoNoValido(String message) {
		super(message);
	}
}
