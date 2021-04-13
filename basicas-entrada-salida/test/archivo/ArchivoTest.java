package archivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import ejercicio.Resolucion;

public class ArchivoTest {

	@Test
	public void testUno() {
		Resolucion resolucion = new Resolucion();
		resolucion.resolver("uno");

		// Es una solución que contempla comparar en cualquier ejercicio
		// Pero que es estricto a que sea exactamente igual
		try {
			byte[] f1 = Files.readAllBytes(Paths.get("casos de prueba/out/uno.out"));
			byte[] f2 = Files.readAllBytes(Paths.get("casos de prueba/out esperado/uno.out"));
			Assert.assertArrayEquals(f1, f2);
		} catch (IOException e) {
			Assert.fail();
		}
	}

}
