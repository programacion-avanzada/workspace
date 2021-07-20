package main;

import java.util.List;

import grafo.*;

public class App {
	public static void main(String[] args) {
		// Creacion de un grafo
		Grafo grafo = new GrafoLista(5);

		grafo.setArista(0, 3, 30, true);
		grafo.setArista(0, 1, 10, true);
		grafo.setArista(0, 4, 100, true);
		grafo.setArista(1, 2, 50, true);
		grafo.setArista(2, 4, 10, true);
		grafo.setArista(3, 4, 60, true);
		grafo.setArista(3, 2, 20, true);

		// mostramos por consola el grafo
		System.out.println(grafo);

		// Dijkstra nos retorna un vector con las distancias desde el nodo de origen
		// (enviado por parametro en el constructor) a todos los nodos del grafo.
		int desde = 0;
		Dijkstra dijkstra = new Dijkstra(grafo, desde);
		double[] distancias = dijkstra.getDistancias();
		for (int i = 0; i < distancias.length; i++)
			System.out.println("Distancia al nodo " + i + ": " + distancias[i]);

		// Mostramos camino desde el nodo origen hasta el nodo 4
		int hasta = 4;
		List<Integer> camino = dijkstra.obtenerCamino(hasta);
		System.out.println("Camino desde el nodo: " + desde + " Hasta el nodo: " + hasta);
		for (int nroNodo : camino) {
			System.out.print(nroNodo + " ");
		}
	}

}
