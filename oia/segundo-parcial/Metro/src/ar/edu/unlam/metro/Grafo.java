package ar.edu.unlam.metro;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Grafo {
	
	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	private int predecesores[];
	private int nodoInicial;	
	private ArrayList<Arista> aristas;
	
	public Grafo (int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
		this.predecesores = new int[cantNodos];
		this.aristas = new ArrayList<Arista>();
	}
	
	public Grafo (int cantNodos) {
		this.cantNodos = cantNodos;
		this.aristas = new ArrayList<Arista>();
	}
	
	public void agregarArista(int origen, int destino, int costo) {
		Arista ari = new Arista(origen, destino, costo);
		if (!aristas.contains(ari)) {			
			aristas.add(ari);
		}
	}
	
	//Recorre la matriz de adyacencia encontrando y agregando las aristas de la misma
	public void encontrarAristas() {
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				//Si existe una arista...
				if (matrizAdy[i][j] > 0 && matrizAdy[i][j] != infinito) {
					agregarArista(i, j, matrizAdy[i][j]);
				}
			}
		}
	}	
	
	public int kruskal() {
		//Creamos una cola de prioridad. 
		//Las colas de prioridad implementadas en Java están basadas en un montículo mínimo. 
		//Esto nos garantiza que las aristas se ordenen automáticamente al ser insertadas,
		//lo cual nos ahorra tiempo y hace las cosas más eficientes.
		PriorityQueue<Arista> pq = new PriorityQueue<Arista>(aristas.size());
		
		//Añadimos las aristas a la cola de prioridad
		for (Arista arista : aristas) {
			pq.add(arista);
		}
		
		//Array que contendrá los conjuntos disjuntos
		int padre[] = new int[cantNodos];
		
		//Realizamos los conjuntos disjuntos
		makeSet(padre);
		
		//MST = Minimum Spanning Tree = Arbol recubridor minimo
		ArrayList<Arista> mst = new ArrayList<Arista>();
		
		/** ESTO ES ESPECIFICO DEL ENUNCIADO, IGNORAR */
		int cantPuentes = 0;
		
		//Indice para que no recorramos de más
		int i = 0;
		
		//El algoritmo de Kruskal se detiene hasta procesar cantNodos-1. 
		//Un nodo es procesado cuando una arista es añadida al MST.
		while (i < cantNodos-1) {
			//Removemos aquella arista que esté primero en la cola de prioridad. 
			//Como está ordenado, será la arista que menor costo tenga.
			Arista ari = pq.remove();
			
			//Chequeamos si añadir esta arista nos forma un ciclo. 
			//Para eso debemos buscar el padre de ambas aristas y preguntar si es el mismo.
			int padre_x = find(padre, ari.getOrigen());
			int padre_y = find(padre, ari.getDestino());
			
			//Si los padres son diferentes, quiere decir que no se forma un ciclo, 
			//por lo que podemos añadir la arista
			if (padre_x != padre_y) {
				//Añadimos la arista al MST
				mst.add(ari);
				//Aumentamos el indice
				i++;
				
				/** ESTO ES ESPECIFICO DEL ENUNCIADO, IGNORAR */
				
				if (esPuente(ari))
					cantPuentes++;
				
				//padre_x y padre_y son los representates de los nodos raíces
				//de dos conjuntos que son disjuntos.
				//Como realizamos una conexión entre ellos, tenemos que unir ambos conjuntos
				union(padre, padre_x, padre_y);
			}
		}
		
		/** ESTO ES ESPECIFICO DEL ENUNCIADO, IGNORAR */
		return cantPuentes;
	}
	
	/** ESTO ES ESPECIFICO DEL ENUNCIADO, IGNORAR */
	public boolean esPuente(Arista ari) {
		return ari.getCosto() == 1;
	}
	
	
	/** https://en.wikipedia.org/wiki/Disjoint-set_data_structure
	 * 
	 * La función de MakeSet es crear un conjunto por cada nodo que se encuentre presente. Es decir,
	 * en cierta forma, aisla y encapsula a cada nodo de los demás. Así, quedamos con N conjuntos (siendo 
	 * N la cantidad de nodos) conformados únicamente por un nodo.	 * 
	 * 
	 * @param padre
	 */
	
	public void makeSet(int padre[]) {
		for (int i = 0; i < padre.length; i++) {
			padre[i] = i;
		}
	}
	
	/** Busca al padre (raíz) del nodo dado. 
	 * 	
	 * @param padre
	 * @param nodo
	 * @return
	 */
	public int find(int padre[], int nodo) {
		if (padre[nodo] != nodo) {
			return find(padre, padre[nodo]); 
		}
		
		return nodo;
	}
	
	/** Union(x,y) uses Find to determine the roots of the trees x and y belong to.
	 *  If the roots are distinct, the trees are combined by attaching the root of one to the root of the other.  
	 * 
	 * Combina aquellos conjuntos que tengan raíces diferentes, uniendo la raíz de uno con la raíz del otro.
	 * 
	 * @param padre
	 * @param x
	 * @param y
	 */
	
	public void union(int padre[], int x, int y) {
		x = find(padre, x);
		y = find(padre, y);
		
		//Si las raíces son diferentes, hacemos que el padre de Y sea X
		if (x != y) {
			padre[y] = x;
		}
	}
	
	public void mostrarMST(ArrayList<Arista> mst) {
		for (Arista arista : mst) {
			System.out.println("Origen: " + arista.getOrigen() + " Costo: " + arista.getCosto() + "Destino: " + arista.getDestino());
		}
	}
}
