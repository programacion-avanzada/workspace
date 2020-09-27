package ar.edu.unlam.minotauro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Minotauro {

	private Grafo grafo;
	private ArrayList<Arista> descansos;
	
	public Minotauro(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public static void main(String[] args) throws IOException {
		Minotauro min = leerArchivo("entrada.in");
		min.resolver();
		min.escribirArchivo("salida.out");
	}
	
	public void resolver() {
		descansos = grafo.kruskal();
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		for (Arista arista : descansos) {
			out.println((arista.getNodoOrigen()+1) + " " + (arista.getNodoDestino()+1) + " " + arista.getCosto());
		}
		
		out.close();
	}
	
	public static Minotauro leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantDescansos = sc.nextInt();
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		
		for (int i = 0; i < cantDescansos; i++) {
			for (int j = 0; j < cantDescansos; j++) {
				int costo = sc.nextInt();
				if (i != j) {
					if (!aristas.contains(new Arista(j, i, costo)));
						aristas.add(new Arista(i, j, costo));
				}
			}
		}
		
		sc.close();
		
		return new Minotauro(new Grafo(aristas, cantDescansos));
	}
	
	
}
