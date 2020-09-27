package ar.edu.unlam.rescatando;

import java.util.ArrayList;

public class Grafo {
	
	private int matrizAdy[][];
	private int predecesores[];	
	private int nodoInicial;
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.predecesores = new int[matrizAdy.length];		
	}
	
	//Halla el nodo con menor distancia que no está incluido en el conjunto solución
	public int hallarNodoMinDist(boolean[] conjSol, int[] dist) {
		int minKey = Integer.MAX_VALUE;
		int nodo = 0;
		
		//Desde 0 hasta la cantidad de nodos 
		for (int i = 0; i < matrizAdy.length; i++) {
			//Si no está incluido en el conjunto de solución, y 
			//el valor de su distancia es menor que el valor infinito
			if (conjSol[i] == false && minKey > dist[i]) {
				minKey = dist[i];
				nodo = i;
			}
		}
		//Retornamos el menor de los nodos
		return nodo;
	}
	
	//Djkstra
	public int[] dijkstra(int nodoInicial) {
		//Este array almacena los nodos que ya se encuentran en el conjunto de solución.
		boolean conjSol[] = new boolean[matrizAdy.length];
		//Distancia. Pesos de las aritas en relacion con claroIni
		int dist[] = new int[matrizAdy.length];
		int infinidad = Integer.MAX_VALUE;
		this.nodoInicial = nodoInicial;
		
		//Inicializamos todas las distancias en infinito
		//Y todos los nodos predecesores como el nodo inicial
		for (int i = 0; i < matrizAdy.length; i++) {
			dist[i] = infinidad;
			predecesores[i] = nodoInicial;
		}
		
		//Seteamos la distancia al nodo inicial en 0
		dist[nodoInicial] = 0;
		
		//Recorremos todos los nodos
		for (int i = 0; i < matrizAdy.length; i++) {
			//Hallamos el nodo que tenga menor distancia
			int nodoActual = hallarNodoMinDist(conjSol, dist);
			
			//Añadimos el nodo al conjunto de solución
			conjSol[nodoActual] = true;
			
			//Iteramos por cada nodo adyacente (vecino) del nodoActual
			for (int vecino = 0; vecino < matrizAdy.length; vecino++) {		
				if (matrizAdy[nodoActual][vecino] > 0) {
					//Si el vecino no se encuentra en el conj. de solución, y si existe
					//adyacencia con el nodoActual
					if (conjSol[vecino] == false && matrizAdy[nodoActual][vecino] != infinidad) {
						//El peso del nodoActual, mas el costo de ir desde nodoActual al vecino
						//D[w] + C[w,i]
						int minimoTentativo = dist[nodoActual] + matrizAdy[nodoActual][vecino];
						
						//Si el costo calculado anterior resulta menor que la distancia actual
						//lo actualizamos
						if (minimoTentativo < dist[vecino])	{
							dist[vecino] = minimoTentativo;
							//En la posición del vecino, guardamos el nodoActual (w) como precedencia
							//ya que hubo un cambio en el costo. Quiere decir que, en el camino, el anterior
							//va a ser este nodo que estamos evaluando
							predecesores[vecino] = nodoActual;
						}
					}
				}
			}			
		}	
		//Retornamos las distancias
		return dist;
	}
	
	public ArrayList<Integer> getCamino(int nodoHasta) {
		int i = nodoHasta;
		ArrayList<Integer> camino = new ArrayList<Integer>();
		camino.add(i);
		
		while (i != nodoInicial) {
			i = predecesores[i];
			camino.add(i);
		}
		
		return camino;
	}
	
}
