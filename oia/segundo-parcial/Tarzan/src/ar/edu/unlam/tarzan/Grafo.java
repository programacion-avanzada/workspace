package ar.edu.unlam.tarzan;

import java.util.ArrayList;
import java.util.Collections;

public class Grafo {
	
	private int matrizAdy[][];
	private int cantNodos;
	private final int infinito = Integer.MAX_VALUE;
	private int predecesores[];
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matriz.length;
		this.predecesores = new int[cantNodos];
	}
	
	public int hallarNodoDistMin(boolean conjSol[], int dist[]) {
		int min = infinito;
		int nodo = 0;
		
		for (int i = 0; i < cantNodos; i++) {
			if (conjSol[i] == false && dist[i] < min) {
				min = dist[i];
				nodo = i;
			}
		}
		
		return nodo;
	}
	
	public void dijkstra(int nodoInicial) {
		boolean conjSol[] = new boolean[cantNodos];
		int dist[] = new int[cantNodos];
		
		for  (int i = 0; i < cantNodos; i++) {
			dist[i] = infinito;
			predecesores[i] = -1;
		}

		dist[nodoInicial] = 0;
		
		int nodo = nodoInicial;
		for (int i = 0; i < cantNodos; i++) {						
			conjSol[nodo] = true;			
			//Recorremos los adyacentes del nodo
			for (int vecino = 0; vecino < cantNodos; vecino++) {
				if (matrizAdy[nodo][vecino] > 0 && matrizAdy[nodo][vecino] != infinito) {
					if (conjSol[vecino] == false) {
						int minT = dist[nodo] + matrizAdy[nodo][vecino];
						
						if (minT < dist[vecino]) {
							dist[vecino] = minT;
							this.predecesores[vecino] = nodo;
						}
						
					}
				}
			}
			
			nodo = hallarNodoDistMin(conjSol, dist);
			
		}		
	}
	
	public ArrayList<Integer> getCamino(int nodoInicial, int nodoHasta) {
		int i = nodoHasta;		
		ArrayList<Integer> camino = new ArrayList<Integer>();
		
		while (i > -1) {
			camino.add(i);
			i = predecesores[i];
		}
		Collections.reverse(camino);
		
		return camino;
		
	}
}
