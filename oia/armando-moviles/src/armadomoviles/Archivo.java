package armadomoviles;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {

	private String nombre;
	private Artesano ar;

	public Archivo(String nom) {

		this.nombre = nom;
		ar = new Artesano();

	}

	public void procesarArchivoIn() throws FileNotFoundException {
		Scanner arch = null;
		try {
			arch = new Scanner(new File(this.nombre));

			if (arch.hasNext()) {
				int cantidad = arch.nextInt();// Leer la cantidad de pesos.

				for (int i = 0; i < cantidad; i++) {
					// Leer cada peso
					int pesoLeido = arch.nextInt();
					ar.verificarVehiculo(i + 1, pesoLeido);
				}

			} else
				System.out.println("El archivo colgantes.in no tiene datos para procesar");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}

	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void generarArchivoOut() throws IOException {

		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter(this.nombre);
			pw = new PrintWriter(archivo);

			if (ar.getCantVarillas() > 0)
				pw.println(ar.getPesoTotal() + " " + ar.getCantVarillas());
			else
				pw.println("No se puede crear móvil.");
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			if (archivo != null)
				archivo.close();
		}

	}

}
