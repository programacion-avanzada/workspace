package edu.unlam.progava.excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Exceptions {

	@Test(expected = ArithmeticException.class)
	public void exception() {
		int div0 = 5 / 0;
		System.out.println(div0);
		Assert.fail();
	}

	@Test
	public void catch_o() {
		try {
			int div0 = 5 / 0;
			System.out.println(div0);
			Assert.fail();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileHandler() {
		File file = new File(""); // null file
		Scanner input = null;
		try {
			input = new Scanner(file);
			Assert.fail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	@Test
	public void customException() {
		@SuppressWarnings("serial")
		class MiExcepcion extends Exception {
			public MiExcepcion(String s) {
				super(s);
			}
		}

		try {
			throw new MiExcepcion("Ejemplo de explicación de error");
			// Assert.fail();
		} catch (MiExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	public void encapsulatedCustomException() {
		@SuppressWarnings("serial")
		class MiExcepcion extends Exception {
			public MiExcepcion(Exception s) {
				super(s);
			}
		}

		try {
			try {
				int div0 = 5 / 0;
				System.out.println(div0);
				Assert.fail();
			} catch (ArithmeticException e) {
				throw new MiExcepcion(e);
				// Assert.fail();
			}
		} catch (MiExcepcion e) {
			e.printStackTrace();
		}
	}
}
