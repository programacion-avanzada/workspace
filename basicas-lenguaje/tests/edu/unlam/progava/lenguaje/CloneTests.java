package edu.unlam.progava.lenguaje;

import org.junit.Assert;
import org.junit.Test;

public class CloneTests {

	// https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#clone()

	// Creates and returns a copy of this object. The precise meaning of "copy" may
	// depend on the class of the object. The general intent is that, for any object
	// x, the expression:

	@Test
	public void rules() throws CloneNotSupportedException {
		Punto uno = new Punto(1.44, -2.72);
		Punto dos = uno.clone();

		// x.clone() != x
		Assert.assertNotSame(uno, dos);
		Assert.assertFalse(uno == dos);

		// x.clone().getClass() == x.getClass()
		Assert.assertSame(uno.getClass(), dos.getClass());

		// x.clone().equals(x)
		Assert.assertEquals(uno, dos);
	}

}
