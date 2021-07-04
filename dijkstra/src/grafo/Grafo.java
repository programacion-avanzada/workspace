package grafo;

import java.util.List;
import java.util.PriorityQueue;

public abstract class Grafo {
	
	
	public abstract int getNodos();
	public abstract void setArista (int desde, int hasta, double costo);
	public abstract Double getArista (int desde, int hasta);
	
	public abstract double [] dijkstra (int desde);

	
}
