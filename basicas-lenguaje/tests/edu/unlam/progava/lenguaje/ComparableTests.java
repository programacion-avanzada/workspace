package edu.unlam.progava.lenguaje;

import org.junit.Assert;
import org.junit.Test;

public class ComparableTests {

	// https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html

	@Test
	public void rules() {
		Punto uno = new Punto(0, 0);
		Punto dos = new Punto(0, 0);
		Punto tres = new Punto(1, 1);

		Assert.assertTrue(uno.compareTo(dos) == 0);
		Assert.assertTrue(uno.compareTo(tres) < 0);
		Assert.assertTrue(tres.compareTo(uno) > 0);

	}
}
