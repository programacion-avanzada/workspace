package edu.unlam.progava.preparandoLaReceta;

import java.util.Set;
import java.util.TreeSet;

public class Heladera {
	
	Set<String> ingredientes = new TreeSet<String>();

	public boolean add(String ingrediente) {
		return ingredientes.add(ingrediente);
	}

	public boolean contains(String ingrediente) {
		return ingredientes.contains(ingrediente);
	}
	
	
}
