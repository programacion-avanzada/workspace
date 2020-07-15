package graph;

public class ListUndirectedGraph extends ListGraph {
	
	public ListUndirectedGraph(int size) {
		super(size);
	}

	@Override
	public void setEdge(int from, int to, double cost) {
		setEdge(from, to, cost);
		setEdge(to, from, cost);
	}

	@Override
	public Double getEdge(int from, int to) {
		if ( graph[from].size() < graph[to].size() ) {
			return getEdge(from, to);
		}
		return getEdge(to, from);
	}

}
