package ar.edu.unlam.cambio;

import java.util.ArrayList;
import java.util.Collections;

public class Grafo {
	
	private int matrizAdy[][];
	private final int infinito = Integer.MAX_VALUE;
	private int cantNodos;
	private int predecesores[];
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matriz.length;
		this.predecesores = new int[cantNodos];
	}
	
	
	public int hallarNodoMinDist(boolean conjSol[], int dist[]) {
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
	
	public int dijkstra(int nodoInicial, int nodoHasta) {
		int dist[] = new int[cantNodos];
		boolean conjSol[] = new boolean[cantNodos];
		
		
		for (int i = 0; i < cantNodos; i++) {
			dist[i] = infinito;
			predecesores[i] = nodoInicial;
		}

		dist[nodoInicial] = 0;
		
		int nodoActual = nodoInicial;
		
		for (int i = 0; i < cantNodos && !conjSol[nodoHasta]; i++) {			
			conjSol[nodoActual] = true;
			for (int vecino = 0; vecino < cantNodos; vecino++) {				
				if (matrizAdy[nodoActual][vecino] > 0 && matrizAdy[nodoActual][vecino] != infinito) {
					if (conjSol[vecino] == false) {
						int minTentativo = dist[nodoActual] + matrizAdy[nodoActual][vecino];
						
						if (minTentativo < dist[vecino]) {
							dist[vecino] = minTentativo;
							predecesores[vecino] = nodoActual;
						}
					}
				}
			}
			
			nodoActual = hallarNodoMinDist(conjSol, dist);
		}
		
		return dist[nodoHasta];		
	}
		
	public ArrayList<Integer> getCamino(int nodoInicial, int nodoHasta) {
		int i = nodoHasta;
		ArrayList<Integer> camino = new ArrayList<Integer>();
		camino.add(i);
		
		while (i != nodoInicial) {
			i = predecesores[i];
			camino.add(i);
		}
		
		Collections.reverse(camino);
		
		return camino;
	}

}
