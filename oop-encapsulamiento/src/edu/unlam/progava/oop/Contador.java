package edu.unlam.progava.oop;

public class Contador {

	private int contador;

	public void contar() {
		this.contador++;
	}

	public void reiniciar() {
		this.contador = 0;
	}

	public int mostrar() {
		return this.contador;
	}
}
