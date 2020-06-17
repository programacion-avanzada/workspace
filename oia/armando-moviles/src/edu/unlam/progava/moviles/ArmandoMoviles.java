
package edu.unlam.progava.moviles;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArmandoMoviles {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Archivo archivo = new Archivo("colgantes");
		archivo.procesarArchivoIn();
		archivo.generarArchivoOut();
	}
}
