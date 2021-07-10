package grafo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class GrafoLista extends Grafo {

	//grafo implementado sobre una lista de colas de prioridad
	private List<PriorityQueue<Nodo>> grafo;
	private int[] predecesores = null;

	public GrafoLista(int tamano) {

		// Los nodos son siempre consecutivos.
		this.grafo = new LinkedList<PriorityQueue<Nodo>>();
		for (int i = 0; i < tamano; i++) {
			this.grafo.add(new PriorityQueue<Nodo>());
		}
	}

	@Override
	public int getNodos() {
		return this.grafo.size();
	}

	@Override
	public void setArista(int desde, int hasta, double costo) {
		this.grafo.get(desde).add(new Nodo(hasta, costo));
	}

	@Override
	public Double getArista(int desde, int hasta) {
		for (Nodo actual : this.grafo.get(desde)) {
			if (actual.getId() == hasta)
				return actual.getPeso();
		}
		return null;
	}

	@Override
	public String toString() {
		String sal = "";
		int i=0;
		for (PriorityQueue<Nodo> nodo : grafo) {
			sal += "Aristas desde nodo (Hacia nodo, costo): " + i;
			sal += nodo + "\n";
			i++;
		}
		return sal;
	}

	@Override
	public double[] dijkstra(int desde) {
		double[] distancias = new double[getNodos()];
		this.predecesores = new int[getNodos()];

		Set<Integer> s = new HashSet<Integer>();

		s.add(desde);

		Set<Integer> vMenosS = new HashSet<Integer>();

		// cargo vMenosS con todos los nodos excepto el que se encuentra ya en s
		for (int i = 0; i < this.getNodos(); i++) {
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

		for (Nodo nodo : this.grafo.get(desde)) {
			distancias[nodo.getId()] = nodo.getPeso();
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
			PriorityQueue<Nodo> auxiliar = new PriorityQueue<Nodo>();
			auxiliar.addAll(this.grafo.get(w));

			while (!auxiliar.isEmpty()) {
				Nodo nodoAux = auxiliar.poll();
				if (distancias[nodoAux.getId()] > distancias[w] + nodoAux.getPeso()) {
					distancias[nodoAux.getId()] = distancias[w] + nodoAux.getPeso();
					this.predecesores[nodoAux.getId()] = w;
				}
			}

		}
		return distancias;
	}
	
	public int [] getPredecesores() {
		return this.predecesores;
	}
	
	public List <Integer> caminoHastaNodo(int desde, int nodo){
		List<Integer> lista= new LinkedList <Integer>();
		Stack <Integer> pila= new Stack <Integer>();
		pila.add(nodo);
		while (this.predecesores[nodo] != desde) {
			pila.add(this.predecesores[nodo]);
			nodo = this.predecesores[nodo];
		}
		pila.add(desde);
		while (!pila.isEmpty()) {
			lista.add(pila.pop());
		}
		return lista;
	}
	
}


