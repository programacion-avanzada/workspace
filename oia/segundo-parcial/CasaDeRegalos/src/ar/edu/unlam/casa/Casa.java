package ar.edu.unlam.casa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Casa {
	
	private Grafo grafo;
	private Color maximo;
	
	public Casa(Grafo grafo) {
		this.grafo = grafo;
	}

	public static void main(String[] args) throws IOException {
		Casa casa = leerArchivo("entrada.in");
		casa.resolver();
		casa.escribirArchivo("salida.out");
	}
	
	public void resolver()	{
		this.maximo = this.grafo.coloreo(10);
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		ArrayList<Nodo> nodos = maximo.getNodos();
		out.println(nodos.size());
		
		for (Nodo nodo : nodos) {
			out.print(nodo.getNodo()+1 + " ");
		}
		
		out.close();
	}
	
	public static Casa leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantNodos = sc.nextInt();
		int matriz[][] = new int[cantNodos][cantNodos];
		
		for (int i = 0; i < cantNodos; i++) {
			int nodo = sc.nextInt()-1;
			int destino = sc.nextInt()-1;
			
			while (destino > 0) {
				matriz[nodo][destino] = 1;
				matriz[destino][nodo] = 1;
				destino = sc.nextInt()-1;
			}
		}
		
		sc.close();
		
		return new Casa(new Grafo(matriz));		
	}
	
	
}
