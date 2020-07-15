package graph;

public abstract class Graph {
	
	public abstract int getNodes();
	public abstract void setEdge(int from, int to, double cost);
	public abstract Double getEdge(int from, int to);
	
	// ----------------------------------------------------
	// Algorithm's implementations
	
	public int[] bfs(int source) {
		int[] hoops = new int[getNodes()];
		hoops[source] = 0;
		
		// TODO: Implement me!
		
		return hoops;
	}
	
	public void dfs(int source) {
		
		// TODO: Implement me!
		
	}
	
	public double[] dijkstra(int source) {
		double[] distances = new double[getNodes()];
		distances[source] = 0;
		
		// TODO: Implement me!
		
		return distances;
	}

}
