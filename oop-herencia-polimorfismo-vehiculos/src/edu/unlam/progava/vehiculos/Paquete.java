package edu.unlam.progava.vehiculos;

public class Paquete {

	private String destino;
	private int peso;
	
	public Paquete(String destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}

	public String getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Paquete [destino=" + destino + ", peso=" + peso + "]";
	}
	
	
}
