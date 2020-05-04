package edu.unlam.progava.lenguaje;

import org.junit.Assert;
import org.junit.Test;

public class EqualsTests {

	// https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#equals(java.lang.Object)

	// Indicates whether some other object is "equal to" this one.

	@Test
	public void rules() {
		Punto uno = new Punto(0, 0);
		Punto dos = new Punto(0, 0);
		Punto tres = new Punto(1, 1);
		Punto cuatro = new Punto(0, 0);

		// It is reflexive: for any non-null reference value x, x.equals(x) should
		// return true.
		Assert.assertTrue(uno.equals(uno));

		// It is symmetric: for any non-null reference values x and y, x.equals(y)
		// should return true if and only if y.equals(x) returns true.
		Assert.assertTrue(uno.equals(dos));
		Assert.assertTrue(dos.equals(uno));

		Assert.assertFalse(uno.equals(tres));

		// It is transitive: for any non-null reference values x, y, and z, if
		// x.equals(y) returns true and y.equals(z) returns true, then x.equals(z)
		// should return true.
		Assert.assertTrue(uno.equals(dos));
		Assert.assertTrue(dos.equals(cuatro));
		Assert.assertTrue(uno.equals(cuatro));

		// It is consistent: for any non-null reference values x and y, multiple
		// invocations of x.equals(y) consistently return true or consistently return
		// false, provided no information used in equals comparisons on the objects is
		// modified.
		for (int i = 0; i < 1_000_000; i++) {
			Assert.assertTrue(uno.equals(dos));
			uno.mover(-0.01, 0.01);

			Assert.assertFalse(uno.equals(tres));
		}

		// For any non-null reference value x, x.equals(null) should return false.
		Assert.assertFalse(uno.equals(null));
	}

}
