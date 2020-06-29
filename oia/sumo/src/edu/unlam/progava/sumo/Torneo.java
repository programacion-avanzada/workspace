package edu.unlam.progava.sumo;

import java.util.ArrayList;
import java.util.List;

public class Torneo {

	private List<Luchador> luchadores = new ArrayList<Luchador>();

	public boolean agregar(Luchador luchador) {
		return luchadores.add(luchador);
	}

	public int[] dominaciones() {
		Luchador uno;
		Luchador dos;
		int[] dominaciones = new int[luchadores.size()];
		for (int i = 0; i < luchadores.size() - 1; i++) {
			for (int j = i + 1; j < luchadores.size(); j++) {
				uno = luchadores.get(i);
				dos = luchadores.get(j);
				
				if (uno.domina(dos)) {
					dominaciones[i]++;
				}
				
				if (dos.domina(uno)) {
					dominaciones[j]++;
				}
			}
		}
		return dominaciones;
	}
	
}
