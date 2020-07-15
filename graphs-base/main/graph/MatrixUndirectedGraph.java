package graph;

public class MatrixUndirectedGraph extends MatrixGraph {

	public MatrixUndirectedGraph(int size) {
		graph = new double[size][];
		for (int i=0; i<size; i++)
			graph[i] = new double[i+1];
	}

	@Override
	public void setEdge(int from, int to, double cost) {
		graph[Math.max(from, to)][Math.min(from, to)] = cost;
	}

	@Override
	public Double getEdge(int from, int to) {
		return graph[Math.max(from, to)][Math.min(from, to)];
	}

}
