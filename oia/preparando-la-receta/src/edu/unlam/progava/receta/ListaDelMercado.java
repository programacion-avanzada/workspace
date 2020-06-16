package edu.unlam.progava.receta;

import java.util.Set;
import java.util.TreeSet;

public class ListaDelMercado {

	public Set<String> faltantes(Heladera heladera, Receta receta) {
		Set<String> faltantes = new TreeSet<String>();
		
		for (String ingrediente : receta) {
			if (!heladera.contains(ingrediente)) {
				faltantes.add(ingrediente);
			}
		}
		
		return faltantes;
	}
	
}
