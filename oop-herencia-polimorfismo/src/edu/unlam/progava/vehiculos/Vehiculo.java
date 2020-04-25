package edu.unlam.progava.vehiculos;

public abstract class Vehiculo {

	protected String chofer;

	public Vehiculo(String chofer) {
		this.chofer = chofer;
	}
	
	public String desplazarse(String origen, String destino) {
		return "Soy un " + this.getTipo() + ", me conduce " + this.chofer + ". Estoy yendo de " + origen + " hasta " + destino;
	}

	public abstract String getTipo();
}
