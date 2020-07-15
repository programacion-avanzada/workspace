package edu.unlam.progava.sumo.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import edu.unlam.progava.sumo.Luchador;
import edu.unlam.progava.sumo.Torneo;

public class ArchivoTorneo {

	private String nombre;

	public ArchivoTorneo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Torneo leer() throws FileNotFoundException {
		File archivo = new File(this.nombre + ".in");
		Scanner lector = new Scanner(archivo);

		int cantidadDeLuchadores = lector.nextInt();
		Torneo torneo = new Torneo();

		int peso;
		int altura;

		for (int i = 0; i < cantidadDeLuchadores; i++) {
			peso = lector.nextInt();
			altura = lector.nextInt();
			torneo.agregar(new Luchador(peso, altura));
		}

		lector.close();
		return torneo;
	}

	public void escribir(int[] dominaciones) throws IOException {
		PrintWriter escritor = new PrintWriter(new FileWriter(this.nombre + ".out"));
		for (int cantidad : dominaciones) {
			escritor.println(cantidad);
		}
		escritor.close();
	}

}
