package edu.unlam.progava.sumo;

import java.io.IOException;

import edu.unlam.progava.sumo.archivos.ArchivoTorneo;

public class App {

	public static void main(String[] args) throws IOException {
		ArchivoTorneo archivo = new ArchivoTorneo("enunciado");
		Torneo torneo = archivo.leer();
		archivo.escribir(torneo.dominaciones());
	}
	
}
