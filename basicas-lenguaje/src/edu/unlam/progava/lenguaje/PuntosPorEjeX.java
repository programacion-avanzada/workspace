package edu.unlam.progava.lenguaje;

import java.util.Comparator;

public class PuntosPorEjeX implements Comparator<Punto> {

	@Override
	public int compare(Punto p1, Punto p2) {
		return p1.getX().compareTo(p2.getX());
	}
}
