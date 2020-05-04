package edu.unlam.progava.lenguaje;

import org.junit.Assert;
import org.junit.Test;

public class HashCodeTests {

	// https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#hashCode()

	// Returns a hash code value for the object. This method is supported for the
	// benefit of hash tables such as those provided by HashMap.

	@Test
	public void rules() {
		Punto uno = new Punto(1, 1);
		Punto dos = new Punto(1, 1);
		Punto tres = new Punto(-3.557471992718208E15, -3.557471992718208E15);

		// Whenever it is invoked on the same object more than once during an execution
		// of a Java application, the hashCode method must consistently return the same
		// integer, provided no information used in equals comparisons on the object is
		// modified. This integer need not remain consistent from one execution of an
		// application to another execution of the same application.
		int hc = uno.hashCode();

		for (int i = 0; i < 1_000_000; i++) {
			Assert.assertEquals(hc, uno.hashCode());
			uno.mover(-0.01, 0.01);
		}

		// If two objects are equal according to the equals(Object) method, then calling
		// the hashCode method on each of the two objects must produce the same integer
		// result.
		Assert.assertEquals(uno, dos);
		Assert.assertEquals(uno.hashCode(), dos.hashCode());

		// It is not required that if two objects are unequal according to the
		// equals(java.lang.Object) method, then calling the hashCode method on each of
		// the two objects must produce distinct integer results. However, the
		// programmer should be aware that producing distinct integer results for
		// unequal objects may improve the performance of hash tables.
		Assert.assertNotEquals(uno, tres);
		Assert.assertEquals(uno.hashCode(), tres.hashCode());

	}
}
