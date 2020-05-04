package edu.unlam.progava.excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class ExcepcionesTests {

	@Test(expected = ArithmeticException.class)
	public void lanzamientoDeExcepcion() {
		int divisionPorCero = 5 / 0;
		System.out.println(divisionPorCero);
		Assert.fail("No debería llegar a este punto");
	}

	@Test
	public void atrapamosLaExcepcion() {
		try {
			int divisionPorCero = 5 / 0;
			System.out.println(divisionPorCero);
			Assert.fail("No debería llegar a este punto");
		} catch (ArithmeticException excepcion) {
			excepcion.printStackTrace();
		}
	}

	@Test
	public void manejadorDeArchivos() {
		File file = new File(""); // archivo inexistente
		Scanner input = null;
		try {
			input = new Scanner(file);
			Assert.fail("No debería llegar a este punto");
		} catch (FileNotFoundException excepcion) {
			excepcion.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	@Test
	public void excepcionPropia() {
		
		class MiExcepcion extends Exception {
			private static final long serialVersionUID = -495059613251522648L;

			public MiExcepcion(String mensaje) {
				super(mensaje);
			}
		}

		try {
			throw new MiExcepcion("Ejemplo de explicación de error");
			// Assert.fail();
		} catch (MiExcepcion excepcion) {
			excepcion.printStackTrace();
		}
	}

	@Test
	public void excepcionPropiaEnvolviendoExcepcionOriginal() {
		
		class MiExcepcion extends Exception {
			private static final long serialVersionUID = -6146170257956329871L;

			public MiExcepcion(Exception excepcion) {
				super(excepcion);
			}
		}

		try {
			try {
				int divisionPorCero = 5 / 0;
				System.out.println(divisionPorCero);
				Assert.fail("No debería llegar a este punto");
			} catch (ArithmeticException excepcion) {
				throw new MiExcepcion(excepcion);
				// Assert.fail();
			}
		} catch (MiExcepcion excepcion) {
			excepcion.printStackTrace();
		}
	}
}
