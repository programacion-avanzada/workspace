package main;

import archivo.Archivo;

public class Main {

	public static void main(String[] args) {
		Archivo archivo = new Archivo("uno");
		double[] datos = archivo.leerArchivo();

		// Elevo al cuadrado
		for(int i = 0; i < datos.length; i++) {
			datos[i] = (double)Math.round(datos[i] * datos[i] * 10000d) / 10000d;
		}

		archivo.guardarArchivo(datos);
	}

}
