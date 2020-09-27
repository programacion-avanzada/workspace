package ar.edu.unlam.metro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Metro {

	
	private Grafo grafo;
	
	//Usar kruskal. Implementar kruskal.
	
	public static void main(String[] args) throws FileNotFoundException {
		Metro met = new Metro();
		met.leerArchivo("entrada.in");
	} 	
	
	public void leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantNodos = sc.nextInt(), cantTuneles = sc.nextInt(), cantPuentes = sc.nextInt();
		Grafo graf = new Grafo(cantNodos);
		
		for (int i = 0; i < cantTuneles; i++) {
			graf.agregarArista(sc.nextInt()-1, sc.nextInt()-1, 0);
		}
		
		for (int i = 0; i < cantPuentes; i++) {
			graf.agregarArista(sc.nextInt()-1, sc.nextInt()-1, 1);
		}
		
		sc.close();
		
		System.out.println(graf.kruskal());
		
	}
	
}
