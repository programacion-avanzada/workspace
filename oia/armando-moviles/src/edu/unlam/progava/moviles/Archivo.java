package edu.unlam.progava.moviles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {

	private String nombre;
	private Artesano artesano;

	public Archivo(String nombre) {
		this.nombre = nombre;
		artesano = new Artesano();
	}

	public void procesarArchivoIn() throws FileNotFoundException {
		Scanner arch = null;
		try {
			arch = new Scanner(new File(this.nombre + ".in"));

			if (arch.hasNext()) {
				int cantidad = arch.nextInt();// Leer la cantidad de pesos.

				for (int i = 0; i < cantidad; i++) {
					// Leer cada peso
					int pesoLeido = arch.nextInt();
					artesano.construirMovil(pesoLeido);
				}

			} else {
				System.out.println("El archivo colgantes.in no tiene datos para procesar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}

	}

	public void generarArchivoOut() throws IOException {

		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter(this.nombre + ".out");
			pw = new PrintWriter(archivo);

			if (artesano.getCantVarillas() > 0)
				pw.println(artesano.getPesoTotal() + " " + artesano.getCantVarillas());
			else
				pw.println("No se puede crear móvil.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (archivo != null)
				archivo.close();
		}
	}
}
