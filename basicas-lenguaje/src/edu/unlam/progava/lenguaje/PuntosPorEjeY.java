package edu.unlam.progava.lenguaje;

import java.util.Comparator;

public class PuntosPorEjeY implements Comparator<Punto> {

	@Override
	public int compare(Punto p1, Punto p2) {
		return p1.getY().compareTo(p2.getY());
	}

}
