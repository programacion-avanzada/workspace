package graph.importer;

import java.io.File;

import graph.ListGraph;
import graph.MatrixGraph;
import graph.Graph;

public class IncidenceListImporter implements GraphImporter {

	@Override
	public Graph importMatrixGraph(File file) {
		Graph graph = new MatrixGraph(0);
		
		// TODO: Implement me!
		
		return graph;
	}

	@Override
	public Graph importListGraph(File file) {
		Graph graph = new ListGraph(0);
		
		// TODO: Implement me!
		
		return graph;
	}

}
