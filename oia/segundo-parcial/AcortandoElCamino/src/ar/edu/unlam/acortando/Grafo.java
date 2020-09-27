package ar.edu.unlam.acortando;

import java.util.ArrayList;
import java.util.Collections;

public class Grafo {
	
	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int predecesores[];
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matriz.length;
		this.predecesores = new int[cantNodos];
	}
	
	public int hallarNodoMinDist(boolean conjSol[], int dist[]) {
		int min = infinito;
		int nodo = -1;
		
		for (int i = 0; i < cantNodos; i++) {
			if (conjSol[i] == false && dist[i] < min) {
				min = dist[i];
				nodo = i;
			}
		}
		
		return nodo;
	}
	
	public int dijkstra(int nodoInicial, int nodoHasta) {
		boolean conjSol[] = new boolean[cantNodos];
		int dist[] = new int[cantNodos];
		
		for (int i = 0; i < cantNodos; i++) {
			dist[i] = infinito;
			predecesores[i] = nodoInicial;
		}
		
		dist[nodoInicial] = 0;
		int nodoActual = nodoInicial;
		
		for (int i = 0; i < cantNodos; i++) {
			conjSol[nodoActual] = true;
			
			for (int vecino = 0; vecino < cantNodos; vecino++) {
				
				if (matrizAdy[nodoActual][vecino] > 0 && matrizAdy[nodoActual][vecino] != infinito) {
					if (conjSol[vecino] == false) {
						int minimoTentativo = dist[nodoActual] + matrizAdy[nodoActual][vecino];
						
						if (minimoTentativo < dist[vecino]) {
							dist[vecino] = minimoTentativo;
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
