package grafo;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class GrafoLista extends Grafo {

	//grafo implementado sobre una lista de colas de prioridad
	private List<PriorityQueue<Adyacente>> grafo;

	public GrafoLista(int tamano) {

		// Los nodos son siempre consecutivos.
		this.grafo = new LinkedList<PriorityQueue<Adyacente>>();
		for (int i = 0; i < tamano; i++) {
			this.grafo.add(new PriorityQueue<Adyacente>());
		}
	}

	@Override
	public int getNodos() {
		return this.grafo.size();
	}

	@Override
	public void setArista(int desde, int hasta, double costo, boolean esDirigido) {
		this.grafo.get(desde).add(new Adyacente(hasta, costo));
		if (!esDirigido)
			this.grafo.get(hasta).add(new Adyacente (desde, costo));
	}

	@Override
	public Double getArista(int desde, int hasta) {
		for (Adyacente actual : this.grafo.get(desde)) {
			if (actual.getId() == hasta)
				return actual.getPeso();
		}
		return null;
	}

	@Override
	public String toString() {
		String sal = "";
		for (PriorityQueue<Adyacente> set : grafo) {
			sal += set + "\n";
		}
		return sal;
	}

	@Override
	public List<PriorityQueue<Adyacente>> getGrafo() {
		return this.grafo;
	}

	@Override
	public List<Integer> getNodosAdyacentes(int nodo) {
		List<Integer> adyacentes = new LinkedList<Integer>();
		PriorityQueue<Adyacente> aux = new PriorityQueue<Adyacente>(grafo.get(nodo));
		while(!aux.isEmpty())
			adyacentes.add(aux.poll().getId());
		return adyacentes;
	}
	
	@Override
	public List<Adyacente> getAdyacentes( int nodo){
		List<Adyacente> adyacentes = new LinkedList<Adyacente>();
		PriorityQueue<Adyacente> aux = new PriorityQueue<Adyacente>(grafo.get(nodo));
		while(!aux.isEmpty())
			adyacentes.add(aux.poll());
		return adyacentes;
	}
	
	@Override
	public List<Arista> getAristas(){
		List<Arista> aristas = new LinkedList <Arista>();
		for (int i=0; i<this.grafo.size(); i++) {
			PriorityQueue<Adyacente> colaAux = new PriorityQueue<Adyacente> (this.grafo.get(i));
			while(!colaAux.isEmpty()) {
				Adyacente aux = colaAux.poll();
				aristas.add(new Arista(i,aux.getId(), aux.getPeso()));
			}
		}
		return aristas;
	}
	
}


