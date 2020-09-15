package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {

	@Test
	public void testUno() {
		try {
			byte[] f1 = Files.readAllBytes(Paths.get("casos de prueba/out/uno.out"));
			byte[] f2 = Files.readAllBytes(Paths.get("casos de prueba/out esperado/uno.out"));
			Assert.assertArrayEquals(f1, f2);
		} catch (IOException e) {
			Assert.fail();
		}
		
		
	}

}
