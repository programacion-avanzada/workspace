package edu.unlam.progava.vehiculos;

import java.util.ArrayDeque;
import java.util.Deque;

public class Remise extends Vehiculo {

	// esto es una pila, no se compliquen :)
	private Deque<String> pasajeros = new ArrayDeque<String>();

	public Remise(String chofer) {
		super(chofer);
	}

	public void subirPasajero(String nombre) {
		if (this.pasajeros.size() < 2) {
			this.pasajeros.push(nombre);
		}
	}

	public void bajarPasajero() {
		this.pasajeros.pop();
	}

	@Override
	public String desplazarse(String origen, String destino) {
		String frase;
		if (this.pasajeros.size() == 0) {
			frase = "Estoy yendo a " + destino + " a recoger a un pasajero";
		} else {
			frase = super.desplazarse(origen, destino) + ". Llevo " + this.pasajeros.size() + " pasajeros";
		}
		return frase;
	}
	
	@Override
	public String getTipo() {
		return "remise";
	}
}
