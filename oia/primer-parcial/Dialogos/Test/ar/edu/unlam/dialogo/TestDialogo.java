package ar.edu.unlam.dialogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class TestDialogo {

	@Test
	public void queeLeeBienElArchivo() throws FileNotFoundException { 
		Dialogo diag = Dialogo.leerArchivo("entrada_base.in");
		
		int num = 7;
		String str[] = { 
				"once",
				"cloneonce",
				"ecounonce",
				"unoonceunioncloneeconeo",
				"unoecoclonecounion",
				"unonceneouno", 
				"unionce"
			};
		
		Assert.assertEquals(num, diag.getCantDialogos());
		Assert.assertArrayEquals(str, diag.getDialogos());
	}
	
	@Test 
	public void queEscribeBienSalida() throws IOException {
		Dialogo diag = Dialogo.leerArchivo("entrada_base.in");
		diag.resolver();
		diag.escribirArchivoSalida("salida_base.out");
		
		String str[] = { 
				"SI 1 0",
				"SI 1 1",
				"NO",
				"SI 3 3",
				"NO",
				"NO", 
				"NO"
			};
		
		
		Scanner sc = new Scanner(new FileReader("salida_base.out"));
		
		for (int i = 0; i < diag.getCantDialogos(); i++) {
			Assert.assertEquals(str[i], sc.nextLine());
		}
		
		sc.close();

	}

}
