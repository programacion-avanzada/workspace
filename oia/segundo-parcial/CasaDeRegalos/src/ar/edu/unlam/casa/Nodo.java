package ar.edu.unlam.casa;

public class Nodo implements Comparable<Nodo> {
	
	private int nodo;
	private int grado;
	
	public Nodo(int nodo, int grado) {
		this.nodo = nodo;
		this.grado = grado;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	@Override
	public int compareTo(Nodo o) {
		if (this.grado > o.grado) {
			return 1;
		}
		else if (this.grado < o.grado) {
			return -1;			
		}
		else 
			return 0;
	}
	
	
}
