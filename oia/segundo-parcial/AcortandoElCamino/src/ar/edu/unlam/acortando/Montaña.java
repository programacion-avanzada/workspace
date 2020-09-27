package ar.edu.unlam.acortando;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Montaña {
	
	private Grafo grafo;
	private ArrayList<Arista> obstruidas;
	private int nodoInicial;
	private int nodoFinal;
	private int distMin;
	
	public Montaña(Grafo grafo, ArrayList<Arista> obs, int ini, int fin) {
		this.grafo = grafo;
		this.obstruidas = obs;
		this.nodoInicial = ini;
		this.nodoFinal = fin;
	}
	
	public static void main(String[] args) throws IOException {
		Montaña mon = leerArchivo("entrada.in");
		mon.resolver();
		
	}
	
	public void resolver() throws IOException {
		distMin = grafo.dijkstra(nodoInicial, nodoFinal);		
		ArrayList<Integer> camino = grafo.getCamino(nodoInicial, nodoFinal);
		ArrayList<Arista> desobstruir = new ArrayList<Arista>();
		
		for (int i = 0; i < camino.size()-1; i++) {
			Arista desob = buscarObstruccion(new Arista(0, camino.get(i), camino.get(i+1), 0));
			
			if (desob != null)
				desobstruir.add(desob);
		}
		
		escribirArchivo("salida.out", desobstruir);
		
		
		
	}
	
	public void escribirArchivo(String path, ArrayList<Arista> desobstruir) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		if (desobstruir.size() < 1) 
		{
			out.println("1 " + distMin);
		} else if (desobstruir.size() == 1) {
			out.println("2 " + desobstruir.get(0).getNumArista() + " " + distMin);
		} else {
			out.println("3 " + desobstruir.get(0).getNumArista() + " " + desobstruir.get(1).getNumArista() + " " + distMin);
		}
		
		out.close();
		
		
	}
	
	public Arista buscarObstruccion(Arista ari) {
		for (Arista arista : obstruidas) {
			if (arista.equals(ari))
				return arista;
		}
		
		return null;
		
	}
	
	public static Montaña leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantNodos = sc.nextInt(), cantGalerias = sc.nextInt(), cantObstruidas = sc.nextInt();
		int matriz[][] = new int[cantNodos][cantNodos];
		ArrayList<Arista> obs = new ArrayList<Arista>();
		
		
		for (int i = 0; i < cantGalerias; i++) {
			int nodoOrig = sc.nextInt()-1, nodoDest = sc.nextInt()-1, costo = sc.nextInt(); 
			
			matriz[nodoOrig][nodoDest] = costo;		
		}
		
		for (int i = 0; i < cantObstruidas; i++) {
			int nodoOrig = sc.nextInt()-1, nodoDest = sc.nextInt()-1, costo = sc.nextInt(); 
			
			if (matriz[nodoOrig][nodoDest] > costo || matriz[nodoOrig][nodoDest] == 0)
			{
				matriz[nodoOrig][nodoDest] = costo;
				//Removemos en caso de que exista otra arista de mayor peso ahi
				obs.remove(new Arista(i+1, nodoOrig, nodoDest, costo));
				obs.add(new Arista(i+1, nodoOrig, nodoDest, costo));
			}
			
			
		}
		
		sc.close();
		
		return new Montaña(new Grafo(matriz), obs, 0, cantNodos-1);
	}
	
	
	

}
