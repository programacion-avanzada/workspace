package ar.edu.unlam.tarzan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarzan {

	private Grafo grafo;
	private int inicial;
	private int destino;
	private ArrayList<Arbol> arboles;
	
	
	public Tarzan(int inicial, int destino, Grafo grafo, ArrayList<Arbol> arboles) {
		this.inicial = inicial;
		this.destino = destino;
		this.grafo = grafo;
		this.arboles = arboles;
	}
	
	public static void main(String[] args) throws IOException {
		Tarzan tar = leerArchivo("./Lote de pruebas/Entradas/Caso 6.in");
		tar.resolver();		
	}	
	
	//Complejidad N^2
	public void resolver() throws IOException {
		grafo.dijkstra(inicial);
		//Obtenemos el camino de predecentes desde el incial hasta el destino
		ArrayList<Integer> camino = grafo.getCamino(inicial, destino);
		escribirArchivo("./Lote de pruebas/Salidas/salida 6.out", camino);		
	}	
	
	public void escribirArchivo(String path, ArrayList<Integer> camino) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		if (camino.size() <= 1) {
			out.println("NO HAY RUTA");
		} else
		{
			for (Integer nodo : camino) {
				Arbol arb = arboles.get(nodo);
				out.println(arb.getX() + " " + arb.getY());
			}
		}
		
		out.close();		
	}
	
	public static Tarzan leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));	
		
		int cantNodos = 0;
		//Guardara la lista de arboles
		ArrayList<Arbol> arboles = new ArrayList<Arbol>();
		//Leemos todo el archivo
		while (sc.hasNextLine()) {
			int x = sc.nextInt(), y = sc.nextInt();
			arboles.add(new Arbol(x, y));
			cantNodos++;
		}
		
		sc.close();	
	
		int matriz[][] = new int[cantNodos][cantNodos];
		
		//Complejidad N^2
		int i = 0, j = 0;
		//Creamos matriz ady
		for (Arbol arbol : arboles) {
			for (Arbol otro : arboles) {
				int dist = arbol.calcularDistanciaEntreArboles(otro);
				//Los que superen 50, los dejamos en 0, indicando que no hay conexion
				if (dist <= 50)
					matriz[i][j] = dist; 
				/*else
					matriz[i][j] = Integer.MAX_VALUE;*/
				j++;
			}
			j = 0;
			i++;
		}
		
		return new Tarzan(0, i-1, new Grafo(matriz), arboles);
	}
	
	
}
