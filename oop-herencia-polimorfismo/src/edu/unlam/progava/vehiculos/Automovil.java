package edu.unlam.progava.vehiculos;

public class Automovil extends Vehiculo {

	private String pasajero;

	public Automovil(String chofer) {
		super(chofer);
	}

	public void subirPasajero(String nombre) {
		// if pasajero == null...
		this.pasajero = nombre;
	}

	public void bajarPasajero() {
		this.pasajero = null;
	}

	@Override
	public String getTipo() {
		return "automóvil";
	}
}
