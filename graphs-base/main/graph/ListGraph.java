package graph;

import java.util.LinkedList;
import java.util.List;

public class ListGraph extends Graph {

	protected List<Node>[] graph;

	@SuppressWarnings("unchecked")
	public ListGraph(int size) {
		graph = new List[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new LinkedList<Node>();
		}
	}

	@Override
	public int getNodes() {
		return graph.length;
	}

	@Override
	public void setEdge(int from, int to, double cost) {
		for (Node current : graph[from]) {
			if (current.number == to) {
				current.cost = cost;
				return;
			}
		}
		graph[from].add(new Node(to, cost));
	}

	@Override
	public Double getEdge(int from, int to) {
		for (Node current : graph[from]) {
			if (current.number == to)
				return current.cost;
		}
		return null;
	}

}
