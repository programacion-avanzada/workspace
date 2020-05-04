package edu.unlam.progava.lenguaje;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CamparatorTests {

	// https://docs.oracle.com/javase/10/docs/api/java/util/Comparator.html

	@Test
	public void comparadorPorEjeX() {
		Punto uno = new Punto(0, 0);
		Punto dos = new Punto(1, -1);

		PuntosPorEjeX comparador = new PuntosPorEjeX();

		Assert.assertTrue(comparador.compare(uno, dos) < 0);
		Assert.assertTrue(comparador.compare(dos, uno) > 0);

	}

	@Test
	public void comparadorPorEjeY() {
		Punto uno = new Punto(0, 0);
		Punto dos = new Punto(1, -1);

		PuntosPorEjeY comparador = new PuntosPorEjeY();

		Assert.assertTrue(comparador.compare(uno, dos) > 0);
		Assert.assertTrue(comparador.compare(dos, uno) < 0);
	}

	@Test
	public void diversosComparadores() {

		List<Punto> puntos = new LinkedList<Punto>();

		puntos.add(new Punto(1, 1));
		puntos.add(new Punto(1, 2));
		puntos.add(new Punto(2, 3));
		puntos.add(new Punto(3, 1));
		puntos.add(new Punto(-5, -5));

		// utiliza el comparador por X
		// puntos.sort(new PuntosPorEjeX());

		// utiliza el comparador por Y
		// puntos.sort(new PuntosPorEjeY());

		// utiliza el comparador natural
		puntos.sort(null);

		// podriamos comprobar posicion a posicion
		// para poder probar, simplemente lo mostramos por pantalla
		System.out.println(puntos);
	}
}
