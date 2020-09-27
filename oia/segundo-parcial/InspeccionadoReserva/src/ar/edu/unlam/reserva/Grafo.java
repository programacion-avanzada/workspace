package ar.edu.unlam.reserva;

import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
	
	
	private int matrizAdy[][];
	private final int infinito = Integer.MAX_VALUE;
	private int cantNodos;
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matriz.length;
	}
	
	
	public int BFS(int nodoInicial, int nodoFinal) {
		boolean estado[] = new boolean[cantNodos];
		int caminos[] = new int[cantNodos];

		
		Queue<Integer> cola = new LinkedList<Integer>();
		
		estado[nodoInicial] = true;
		cola.offer(nodoInicial);
		caminos[nodoInicial] = 1;
		
		
		while (!cola.isEmpty()) {
			int nodo = cola.poll();
			
			for (int i = 0; i < cantNodos; i++) {
				if (matrizAdy[nodo][i] > 0 && matrizAdy[nodo][i] != infinito) {
					if (estado[i] == false) {
						estado[i] = true;
						cola.offer(i);
					}
					//El camino del nodo que estamos viendo más la cantidad de caminos con los que pudimos
					//llegar al nodo predecesor
					caminos[i] += caminos[nodo];
				}
			}
		}
		
		return caminos[nodoFinal];		
	}
}
