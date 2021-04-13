package ejercicio;

import archivo.Archivo;

public class Resolucion {
	public void resolver(String nombreArchivo) {
		Archivo archivo = new Archivo(nombreArchivo);
		double[] datos = archivo.leerArchivo();

		// Elevo al cuadrado
		for (int i = 0; i < datos.length; i++) {
			datos[i] = (double) Math.round(datos[i] * datos[i] * 10000d) / 10000d;
		}

		archivo.guardarArchivo(datos);
	}
}
