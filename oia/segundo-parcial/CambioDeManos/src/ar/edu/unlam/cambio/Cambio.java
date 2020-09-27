package ar.edu.unlam.cambio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cambio {
	
	private Grafo grafo;
	private int esqIni;
	private int esqFin;
	private ArrayList<Arista> calles;
	private ArrayList<Arista> callesCambiar;
	private int distMin;
	
	public Cambio(Grafo grafo, ArrayList<Arista> calles, int esqIni, int esqFin) {
		this.grafo = grafo;
		this.esqIni = esqIni;
		this.esqFin = esqFin;
		this.calles = calles;
		this.callesCambiar = new ArrayList<Arista>();
	}
	
	public static void main(String[] args) throws IOException {
		Cambio cam = leerArchivo("entrada.in");
		cam.resolver();
		cam.escribirArchivo("salida.out");
	}
	
	public void resolver() {
		this.distMin = grafo.dijkstra(esqIni, esqFin);
		ArrayList<Integer> camino = grafo.getCamino(esqIni, esqFin);
		
		for (int i = 0; i < camino.size()-1; i++) {
			if (!calles.contains(new Arista(0, camino.get(i), camino.get(i+1), 0))) {
				callesCambiar.add(buscarCalle(new Arista(0, camino.get(i+1), camino.get(i), 0)));				
			}
		}		
	}
	
	public Arista buscarCalle(Arista ari) {
		for (Arista arista : calles) {
			if (arista.equals(ari)) {
				return arista;
			}
		}
		
		return null;		
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(distMin);
		for (Arista arista : callesCambiar) {
			out.print(arista.getNumCalle() + " ");
		}
		
		out.close();
		
	}
	
	public static Cambio leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantNodos = sc.nextInt(), esqIni = sc.nextInt()-1, esqFin = sc.nextInt()-1, cantCalles = sc.nextInt();
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		int matriz[][] = new int[cantNodos][cantNodos];
		
		for (int i = 0; i < cantCalles; i++) {
			int orig = sc.nextInt()-1, dest = sc.nextInt()-1, costo = sc.nextInt();
			matriz[orig][dest] = costo;
			matriz[dest][orig] = costo;
			
			aristas.add(new Arista(i+1, orig, dest, costo));
		}
		
		sc.close();
		
		return new Cambio(new Grafo(matriz), aristas, esqIni, esqFin);		
	}
	

}
