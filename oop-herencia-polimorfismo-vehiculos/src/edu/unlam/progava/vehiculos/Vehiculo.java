package edu.unlam.progava.vehiculos;

import java.util.LinkedList;
import java.util.List;

public abstract class Vehiculo {
	
	protected int carga = 0;
	
	private List<Paquete> paquetes = new LinkedList<Paquete>();
	public abstract boolean puedeLlevar(Paquete paquete);
	
	public final void cargar(Paquete paquete) {
		if (puedeLlevar(paquete)) {
			this.paquetes.add(paquete);
			this.carga += paquete.getPeso();
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [carga=" + carga + ", paquetes=" + paquetes + "]";
	}
	
	public int getCarga() {
		return this.carga;
	}
	
	public int getPaquetes() {
		return this.paquetes.size();
	}

	protected boolean puedeCargar(Paquete paquete) {
		return paquete.getPeso() + this.carga <= getCapacidadMaxima();
	}

	protected abstract int getCapacidadMaxima();
}
