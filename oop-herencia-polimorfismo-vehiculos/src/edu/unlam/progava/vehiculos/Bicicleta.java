package edu.unlam.progava.vehiculos;

public class Bicicleta extends Vehiculo {

	private String zona;
	
	public Bicicleta(String zona) {
		this.zona = zona;
	}
	
	public boolean puedeLlevar(Paquete paquete) {
		boolean paqueteEnZona = paquete.getDestino() == this.zona;
		return paqueteEnZona && puedeCargar(paquete);
	}

	@Override
	protected int getCapacidadMaxima() {
		return 20;
	}
	
}
