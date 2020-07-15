package graph.exporter;

import java.io.File;

import graph.Graph;

public interface Exporter {
	
	public void export(Graph graph, File file);

}
