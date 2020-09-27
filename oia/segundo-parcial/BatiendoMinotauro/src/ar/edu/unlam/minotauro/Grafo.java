package ar.edu.unlam.minotauro;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Grafo {
	
	private int matrizAdy[][];
	private int cantNodos;
	private ArrayList<Arista> aristas;
	
	public Grafo (int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matriz.length;
	}
	
	public Grafo(ArrayList<Arista> aristas, int cantNodos) {
		this.aristas = aristas;
		this.cantNodos = cantNodos;
	}
	
	public ArrayList<Arista> kruskal() {
		int cantNodosProcesados = 0;
		int padre[] = new int[cantNodos];
		PriorityQueue<Arista> pq = new PriorityQueue<Arista>();
		
		for (Arista arista : aristas) {
			pq.offer(arista);
		}
		
		makeSet(padre);
		
		ArrayList<Arista> mst = new ArrayList<Arista>();
		
		while (cantNodosProcesados < cantNodos-1) {
			//Sacamos la arista de menor peso
			Arista ari = pq.remove();
			
			int padre_x = find(padre, ari.getNodoOrigen());
			int padre_y = find(padre, ari.getNodoDestino());
			
			if (padre_x != padre_y) {
				mst.add(ari);
				union(padre, padre_x, padre_y);
				cantNodosProcesados++;
			}
		}
		
		return mst;
	}
	
	public void makeSet(int padre[]) {
		for (int i = 0; i < cantNodos; i++) {
			padre[i] = i;
		}
	}
	
	private int find(int padre[], int nodo) {
		//Si el padre del nodo es diferente al nodo, quiere decir que no es
		//el padre del conjunto
		if (padre[nodo] != nodo) {
			return find(padre, padre[nodo]);
		}
		return nodo;
	}
	
	private void union(int padre[], int x, int y) {
		x = find(padre, x);
		y = find(padre, y);
		
		//Si los padres de los conjuntos son diferentes...
		if (x != y) {
			padre[y] = x;
		}
	}
	
	
}
