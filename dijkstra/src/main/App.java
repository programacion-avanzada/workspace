package main;


import java.util.List;

import grafo.GrafoLista;

public class App {
	public static void main(String[] args) {
		//Creacion de un grafo
		GrafoLista grafo = new GrafoLista(5);
		
		grafo.setArista(0, 3,30);
		grafo.setArista(0, 1,10);
		grafo.setArista(0, 4,100);
		grafo.setArista(1, 2,50);
		grafo.setArista(2, 4,10);
		grafo.setArista(3,4,60);
		grafo.setArista(3,2,20);
		
		//mostramos por consola el grafo
		System.out.println(grafo);
		
		//Dijkstra nos retorna un vector con las distancias desde el nodo de origen (enviado por parametro) a todos los nodos del grafo
		int desde=0;
		double [] distancias = grafo.dijkstra(desde);
		for (int i=0; i<distancias.length; i++)
			System.out.println("Distancia al nodo "+ i+": "+distancias[i]);
		
		//Mostramos camino desde el nodo origen hasta el nodo 4
		int hasta = 4;
		List<Integer> camino = grafo.caminoHastaNodo(desde, hasta);
		
		for (int nroNodo : camino) {
			System.out.println(nroNodo);
		}
	}
	
}
