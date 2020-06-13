package edu.unlam.progava.receta;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Receta implements Iterable<String> {

	private Set<String> ingredientes = new TreeSet<String>();

	public boolean add(String ingrediente) {
		return ingredientes.add(ingrediente);
	}
	
	@Override
	public Iterator<String> iterator() {
		return ingredientes.iterator();
	}
	
}
