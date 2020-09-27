package ar.edu.unlam.casa;

import java.util.ArrayList;

public class Color {
	
	private ArrayList<Nodo> nodos;
	private int color;
	
	public Color(int num) {
		this.color = num;
		this.nodos = new ArrayList<Nodo>();
	}
	
	public ArrayList<Nodo> getNodos() {
		return this.nodos;
	}
}
