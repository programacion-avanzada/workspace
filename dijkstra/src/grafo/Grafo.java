package grafo;

import java.util.List;
import java.util.PriorityQueue;

public abstract class Grafo {

	public abstract int getNodos();

	public abstract Double getArista(int desde, int hasta);

	public abstract void setArista(int desde, int hasta, double costo, boolean esDirigido);

	public abstract List<PriorityQueue<Adyacente>> getGrafo();

	public abstract List<Integer> getNodosAdyacentes(int nodo);

	public abstract List<Adyacente> getAdyacentes(int nodo);

	public abstract List<Arista> getAristas();

}
