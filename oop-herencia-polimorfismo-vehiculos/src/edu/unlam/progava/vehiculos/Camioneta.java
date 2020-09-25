package edu.unlam.progava.vehiculos;

import java.util.LinkedList;
import java.util.List;

public class Camioneta extends Vehiculo {

	private List<String> zonas = new LinkedList<String>();
		
	public boolean agregarZona(String zona) {
		return zonas.add(zona);
	}

	public boolean puedeLlevar(Paquete paquete) {
		boolean paqueteEnZona = this.zonas.contains(paquete.getDestino());
		return paqueteEnZona && puedeCargar(paquete);
	}

	@Override
	protected int getCapacidadMaxima() {
		return 2000;
	}
	
}
