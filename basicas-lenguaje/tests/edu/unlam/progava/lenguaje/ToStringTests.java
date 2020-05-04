package edu.unlam.progava.lenguaje;

import org.junit.Assert;
import org.junit.Test;

public class ToStringTests {

	// public String toString()

	// Returns a string representation of the object. In general, the toString
	// method returns a string that "textually represents" this object. The result
	// should be a concise but informative representation that is easy for a person
	// to read. It is recommended that all subclasses override this method.

	@Test
	public void example() {

		Punto uno = new Punto(1.44, -2.72);
		Assert.assertEquals("(1.44, -2.72)", uno.toString());

		Punto dos = new Punto(-1.44, 2.72);
		Assert.assertEquals("(-1.44, 2.72)", dos.toString());

	}
}
