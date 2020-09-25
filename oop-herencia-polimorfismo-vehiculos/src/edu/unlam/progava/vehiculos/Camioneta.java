package edu.unlam.progava.vehiculos;

import java.util.LinkedList;
import java.util.List;

public class Camioneta extends Vehiculo {

	private final int CAPACIDAD_MAXIMA = 2000;
	
	private List<String> zonas = new LinkedList<String>();
		
	public boolean agregarZona(String zona) {
		return zonas.add(zona);
	}

	public boolean puedeLlevar(Paquete paquete) {
		if (this.zonas.contains(paquete.getDestino())) {
			if (paquete.getPeso() + this.carga <= CAPACIDAD_MAXIMA) {
				return true;
			}
		}
		return false;
	}
	
}
