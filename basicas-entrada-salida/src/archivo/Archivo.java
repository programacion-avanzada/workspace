package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public double[] leerArchivo() {
		Scanner arch = null;
		double[] datos = null;

		try {
			arch = new Scanner(new File("casos de prueba/in/" + this.nombre + ".in"));
			arch.useLocale(Locale.ENGLISH);

			int cant = arch.nextInt();
			datos = new double[cant];
			for (int i = 0; i < cant; i++) {
				double n = arch.nextDouble();
				datos[i] = n;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}
		return datos;

	}

	public void guardarArchivo(double[] datos) {
		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter("casos de prueba/out/" + this.nombre + ".out");
			pw = new PrintWriter(archivo);

			for(int i = 0; i < datos.length; i++) {
				pw.println(datos[i]);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}