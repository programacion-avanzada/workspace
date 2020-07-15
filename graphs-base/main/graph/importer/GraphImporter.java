package graph.importer;

import java.io.File;

import graph.Graph;

public interface GraphImporter {
	
	public Graph importMatrixGraph(File file);
	public Graph importListGraph(File file);

}
