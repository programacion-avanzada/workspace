package ar.edu.unlam.casa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Grafo {

	private final int infinito = Integer.MAX_VALUE;
	private int matrizAdy[][];
	private int cantNodos;
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.cantNodos = matrizAdy.length;
	}
	
		 
	//El algoritmo de coloreo no solo me da la cantidad de colores,
	//si no que también me da los nodos que pertenecen a cada uno de sus colores	
	public Color coloreo(int cantPasadas) {
		//Lista que contiene los nodos que todavía faltan por pintar
		ArrayList<Nodo> noColoreados = new ArrayList<Nodo>();
		//Lista que contiene los colores usados
		ArrayList<Color> colores = new ArrayList<Color>();
		//Booleana que indica se si halló un nodo adyacente
		boolean encontrado;
		
		//Color con mayor cantidad de nodos encontrado en alguna de las pasadas
		Color maximo = null;
		
		//Recorre la matriz de adyacencia y rellena la lista con objetos de la clase Nodo
		//con sus grados ya calculados
		hallarGrados(noColoreados);
		
		for (int i = 0; i < cantPasadas; i++) {
			//Sorteamos la lista en orden descendiente
			Collections.sort(noColoreados, Collections.reverseOrder());		
			
			//Variable que se incrementará luego de cada ciclo para simular el uso de colores diferentes
			int colorActual = 1;
			
			//Ejecutamos este ciclo mientras hayan nodos sin pintar
			while (!noColoreados.isEmpty()) {
				//Instancia de la clase color, la cual contiene un atributo del tipo ArrayList<Nodo>,
				//que guarda una lista de nodos asociados a ese color.
				//Notar cómo la instanciamos con el valor de colorActual
				Color color = new Color(colorActual);
				colores.add(color);
				
				//Obtenemos el primer nodo de la lista de los noColoreados
				Iterator<Nodo> iter = noColoreados.iterator();
				Nodo nodo = iter.next();
				
				//Mientras que el iterator no se quede sin nodos para sacar...
				while (nodo != null) {
					//Encontrado me indica si hay adyacentes del mismo color
					encontrado = false;
					
					//Sacamos, si existe, el primer nodo de la lista de COLORACTUAL
					Iterator<Nodo> iterPintados = color.getNodos().iterator();
					Nodo nodoPintado = null;
					
					if (iterPintados.hasNext())			
						nodoPintado = iterPintados.next();
					
					//Este ciclo comprueba si hay algún nodo pintado de COLORACTUAL que se adyacente
					//al nodo que sacamos de la lista. Si hay al menos un adyacente, entonces no podemos pintar ese nodo
					//del mismo color.
					while (nodoPintado != null) {
						//¿Es el nodo pintado adyacente al que no está pintado?
						if (matrizAdy[nodo.getNodo()][nodoPintado.getNodo()] > 0 
								&& matrizAdy[nodo.getNodo()][nodoPintado.getNodo()] != infinito) {
							encontrado = true;
						}
						//Saco el siguiente nodo de los de este color, si existe
						if (iterPintados.hasNext())
							nodoPintado = iterPintados.next();
						else 
							nodoPintado = null;
					}
					
					//Si no encontré ninguno que sea adyacente, pinto al nodo con colorActual
					if (encontrado == false) {
						//Saco al nodo de los noColoreados
						//noColoreados.remove(nodo);
						iter.remove();
						//Lo agrego a la lista de nodos de colorActual
						color.getNodos().add(nodo);
					}
					//Saco el siguiente nodo de los noColoreados (si es que hay)
					if (iter.hasNext())
						nodo = iter.next(); 
					else
						nodo = null;
				}			
				colorActual++;
			}
			
			//Hallamos el conjunto con mayor cantidad de nodos y lo guardamos en un max
			maximo = hallarCojuntoMaximo(maximo, hallarColorConMasNodos(colores));
			
			//Volvemos a buscar los nodos con sus grados
			hallarGrados(noColoreados);
			//Pero esta vez desordenamos el vector para que haga un recorrido ligeramente diferente
			desordenar(noColoreados);
		}
		
		
		//Retornamos el máximo
		return maximo;		
	}	
	
	public Color hallarCojuntoMaximo(Color col1, Color col2) {
		if (col1 != null) {
			if (col1.getNodos().size() >= col2.getNodos().size())
				return col1;
			else
				return col2;
		}
		
		return col2;
	}
	
	public Color hallarColorConMasNodos(ArrayList<Color> colores) {
		Color max = colores.get(0);
		for (Color color : colores) {
			if (color.getNodos().size() > max.getNodos().size()) 
				max = color;
		}
		
		return max;
	}
	
	
	public void desordenar(ArrayList<Nodo> lista) {
		int indice1 = (int) Math.floor(Math.random()*lista.size());
		int indice2 = (int) Math.floor(Math.random()*lista.size());
		
		Collections.swap(lista, indice1, indice2);
	}
	
	public void hallarGrados(ArrayList<Nodo> lista) {
		int cant = 0;
		
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if (matrizAdy[i][j] > 0 && matrizAdy[i][j] != infinito) {
					cant++;
				}
			}			
			Nodo n = new Nodo(i, cant);
			lista.add(n);
			cant = 0;
		}
	}
}
