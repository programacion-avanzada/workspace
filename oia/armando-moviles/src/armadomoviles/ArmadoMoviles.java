
package armadomoviles;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArmadoMoviles {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Archivo archivo = new Archivo("colgantes");
		archivo.procesarArchivoIn();
		archivo.generarArchivoOut();
	}
}
