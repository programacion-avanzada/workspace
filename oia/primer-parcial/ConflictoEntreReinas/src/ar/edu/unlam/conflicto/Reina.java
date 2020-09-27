package ar.edu.unlam.conflicto;

import java.util.TreeSet;

public class Reina {
	
	private int numReina;
	private int fila;
	private int columna;
	private TreeSet<Integer> conflictoCon;
	
	public Reina(int numReina, int fil, int col) {
		this.fila = fil;
		this.columna = col;
		this.numReina = numReina;
		this.conflictoCon = new TreeSet<Integer>();
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}	
	
	public void addConflictoCon(Integer num) {
		conflictoCon.add(num);
	}

	public int getNumReina() {
		return numReina;
	}

	public void setNumReina(int numReina) {
		this.numReina = numReina;
	}

	public TreeSet<Integer> getConflictoCon() {
		return conflictoCon;
	}

	public void setConflictoCon(TreeSet<Integer> conflictoCon) {
		this.conflictoCon = conflictoCon;
	}
}
