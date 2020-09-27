package ar.edu.unlam.reserva;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Reserva {
	
	private Grafo grafo;
	private int cantCaminos;
	
	public Reserva(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public static void main(String[] args) throws IOException {
		Reserva res = leerArchivo("entrada.in");
		res.resolver();
		res.escribirArchivo("salida.out");		
	}
	
	public void resolver() {
		cantCaminos = grafo.BFS(0, 9);
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(this.cantCaminos);
		
		out.close();
		
	}	
	
	public static Reserva leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantNodos = sc.nextInt(), cantConexiones = sc.nextInt();
		int matriz[][] = new int[cantNodos][cantNodos];
		
		for (int i = 0; i < cantConexiones; i++) {
			int nodoOrig = sc.nextInt()-1, nodoDest = sc.nextInt()-1;
			
			matriz[nodoOrig][nodoDest] = 1;
		}
		
		sc.close();
		
		return new Reserva(new Grafo(matriz));	
		
	}

}
