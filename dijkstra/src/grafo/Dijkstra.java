package grafo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Dijkstra {
	private Grafo grafo;
	private int nodoInicial;
	private int[] predecesores;
	private double[] distancias;
	private Set<Integer> s = new HashSet<Integer>();
	private Set<Integer> vMenosS = new HashSet<Integer>();

	public Dijkstra(Grafo grafo, int nodoInicial) {
		this.grafo = grafo;
		this.nodoInicial = nodoInicial;
		calcularDijkstra(this.nodoInicial);
	}

	private void calcularDijkstra(int desde) {
		this.distancias = new double[grafo.getNodos()];
		this.predecesores = new int[grafo.getNodos()];

		s.add(desde);

		// cargo vMenosS con todos los nodos excepto el que se encuentra ya en s
		for (int i = 0; i < this.grafo.getNodos(); i++) {
			if (desde != i)
				vMenosS.add(i);
		}

		// Se inicializa el vector distancias con infinito en todas las posiciones

		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Double.MAX_VALUE;
		}

		distancias[desde] = 0;

		// Se inicializa vector de predecesores con el nodo inicial

		for (int i = 0; i < this.predecesores.length; i++) {
			this.predecesores[i] = desde;
		}

		// Primer paso: se carga en distancias todas las distancias a nodos directos
		// desde el nodo inicial

		List<Adyacente> adyacentes = this.grafo.getAdyacentes(desde);
		for (Adyacente adyacente : adyacentes) {
			distancias[adyacente.getId()] = adyacente.getPeso();
		}

		// Segundo y n pasos... Mientras vMenosS no sea vacio

		while (!vMenosS.isEmpty()) {
			boolean bandera = false;
			double min = 0;
			int w = 0;

			for (Integer integer : vMenosS) {
				if (!bandera) {
					min = distancias[integer];
					w = integer;

					bandera = true;
				} else {
					if (distancias[integer] < min) {
						min = distancias[integer];
						w = integer;

					}
				}

			}
			// ya calcule el minimo
			vMenosS.remove(w);
			s.add(w);
			PriorityQueue<Adyacente> auxiliar = new PriorityQueue<Adyacente>();
			auxiliar.addAll(this.grafo.getGrafo().get(w));

			while (!auxiliar.isEmpty()) {
				Adyacente nodoAux = auxiliar.poll();
				if (distancias[nodoAux.getId()] > distancias[w] + nodoAux.getPeso()) {
					distancias[nodoAux.getId()] = distancias[w] + nodoAux.getPeso();
					this.predecesores[nodoAux.getId()] = w;
				}
			}

		}

	}

	public int[] getPredecesores() {
		return this.predecesores;
	}

	public double[] getDistancias() {
		return this.distancias;
	}

	public List<Integer> obtenerCamino(int nodo) {
		List<Integer> lista = new LinkedList<Integer>();
		Stack<Integer> pila = new Stack<Integer>();
		pila.add(nodo);
		while (this.predecesores[nodo] != this.nodoInicial) {
			pila.add(this.predecesores[nodo]);
			nodo = this.predecesores[nodo];
		}
		pila.add(this.nodoInicial);
		while (!pila.isEmpty()) {
			lista.add(pila.pop());
		}
		return lista;
	}

	public double getDistancia(int nodo) {
		return this.distancias[nodo];
	}
}
