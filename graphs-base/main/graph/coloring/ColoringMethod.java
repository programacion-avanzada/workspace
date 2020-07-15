package graph.coloring;

import graph.Graph;
import graph.coloring.order.Order;

public interface ColoringMethod {

	public Coloring paint(Graph graph, Order order);
	
}
