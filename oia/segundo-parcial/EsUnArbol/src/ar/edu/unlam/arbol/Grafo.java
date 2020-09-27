package ar.edu.unlam.arbol;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matriz.length;

	}
	
	
	public boolean[] DFS(int nodoInicial) {
		boolean visitado[] = new boolean[cantNodos];
		Stack<Integer> pila = new Stack<Integer>();
		
		pila.push(nodoInicial);
		visitado[nodoInicial] = true;
		
		while (!pila.isEmpty()) {
			int nodoActual = pila.pop();
			
			for (int i = 0; i < cantNodos; i++) {
				if (matrizAdy[nodoActual][i] > 0 && matrizAdy[nodoActual][i] != infinito) {
					if (visitado[i] == false) {
						visitado[i] = true;
					}								
				}
			}
		}
		
		return visitado;
	}
}
