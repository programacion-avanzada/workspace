package edu.unlam.progava.moviles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Artesano {

	private int cantVarillas;
	private int pesoTotal;
	private Map<Integer, Integer> colgantes;
	private List<Movil> moviles;

	public Artesano() {
		this.cantVarillas = 0;
		this.pesoTotal = 0;
		this.colgantes = new HashMap<Integer, Integer>();
		this.moviles = new LinkedList<Movil>();
	}

	public int getCantVarillas() {
		return cantVarillas;
	}

	public int getPesoTotal() {
		return pesoTotal;
	}

	public void construirMovil(int peso) {
		// ¿Existe el peso en el mapa?
		if (colgantes.containsKey(peso)) {
			// Sí, entonces cumple la condición para formar el móvil.
			Movil movil = new Movil(peso, peso);
			// el problema no lo pide, pero guardamos los móviles
			this.moviles.add(movil);
			this.pesoTotal += movil.getPesoTotal();
			this.cantVarillas++;

			// Eliminar el peso del colgante del mapa.
			colgantes.remove(peso);
		} else {
			// Si no existe agregarlo al mapa.
			colgantes.put(peso, 1);
		}
	}
}
