package graph;

public class MatrixGraph extends Graph {

	protected double[][] graph;
	
	protected MatrixGraph() {}

	public MatrixGraph(int size) {
		graph = new double[size][size];
	}

	@Override
	public int getNodes() {
		return graph.length;
	}

	@Override
	public void setEdge(int from, int to, double cost) {
		graph[from][to] = cost;
	}

	@Override
	public Double getEdge(int from, int to) {
		return graph[from][to];
	}

}
