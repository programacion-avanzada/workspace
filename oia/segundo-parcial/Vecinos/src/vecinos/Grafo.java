package vecinos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
	
	private int matrizAdy[][];
	private int cantNodos;
	private final int infinito = Integer.MAX_VALUE;
	
	public Grafo(int matrizAdy[][]) {
		this.matrizAdy = matrizAdy;
		this.cantNodos = matrizAdy.length; 
	}
	
	public int getCantNodos() {
		return this.cantNodos;
	}
		
	public ArrayList<Nodo> BFS(int nodoInicial, int nodoOponente) {
		boolean estado[] = new boolean[cantNodos];
		int padre[] = new int[cantNodos];
		boolean cadCreadas[][] = new boolean[cantNodos][cantNodos];
		Queue<Integer> cola = new LinkedList<>();		
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		
		//Creamos/inicializamos un ArrayList que contiene todos los nodos. 
		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i));
		}
		
		//Seteamos al padre del nodo inicial como -1. Esto nos sirve como delimitador para más adelante.
		padre[nodoInicial] = -1;
		//No queremos pasar por el nodo oponente, ni armar cadenas con el mismo (ya que no nos sirve)
		estado[nodoOponente] = true;	
		//Seteamos que ya pasamos por este nodo...
		estado[nodoInicial] = true;
		cola.offer(nodoInicial);
		
		while (!cola.isEmpty()) {
			//Desencolamos el nodo más proximo de la cola
			int nodo = cola.poll();
			//Recorremos por cada nodo que sea adyacente al nodo actual
			for (int i = 0; i < cantNodos; i++)	{
				//Si son adyacentes...
				if (matrizAdy[nodo][i] > 0 && matrizAdy[nodo][i] != infinito) {
					if (estado[i] == false) {
						estado[i] = true;
						padre[i] = nodo;	
						//Encolamos el nodo adyacente al que estamos analizando
						cola.offer(i);
					}
										
					//Lo que hacemos acá adentro es armar la cadena que surge desde el nodoInicial, hasta
					//el nodo adyacente que acabamos de pasar
					
					//Si el nodo adyacente que estamos viendo es diferente al nodoInicial, y al nodoOponete, 
					//y si no existe ya una cadena que haya sido creada desde el nodo adyacente 
					//hasta el nodo en el que estamos parados
					if (i != nodoInicial && i != nodoOponente && !cadCreadas[nodo][i]) {
						//Marcamos como creada una cadena entre el nodo y el adyacente
						cadCreadas[nodo][i] = true;
						//Creamos una nueva cadena de amistad
						Cadena cad = new Cadena();
						//Conectamos el nodo en que estamos parados, con el nodo de destino (ultimo eslabon de la cadena)
						cad.getAristas().add(new Arista(nodo, i, matrizAdy[nodo][i]));
						
						//Vamos creando eslabones hasta toparnos con el nodoInicial (hasta quedarnos sin padre)
						int p = nodo;
						while (padre[p] !=  -1) {
							//Creamos una arista que va desde el padre del nodo en que estamos parado,
							//hasta el nodo en que estamos parado
							cad.getAristas().add(new Arista(padre[p], p, matrizAdy[padre[p]][p]));
							//Buscamos al padre
							p = padre[p];
						}
						
						//Calcula el valor de la cadena en base al eslabon minimo
						cad.calcularValor();
						//Agregamos la cadena al nodo
						nodos.get(i).getCadenas().add(cad);						
					}
				}
			}
		}
		
		return nodos;
	}	
}
