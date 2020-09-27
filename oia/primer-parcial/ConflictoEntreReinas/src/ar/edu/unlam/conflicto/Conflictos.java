package ar.edu.unlam.conflicto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Conflictos {

	private int dimension;
	private int tablero[][];
	private ArrayList<Reina> reinas;
	
	public Conflictos(int dimension) {
		this.dimension = dimension;
		this.tablero = new int[dimension][dimension];
		this.reinas = new ArrayList<Reina>();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Conflictos conf = leerArchivo("entrada.in");
		conf.buscarConflictos();
	}
	
	public void buscarConflictos() {		
		for (Reina reina : reinas) {
			int fila = reina.getFila()-1; //-1 para que me dé la fila "lógica"
			int col = reina.getColumna()-1; //idem
			
			chequearIzquierda(reina, fila, col);
			chequearDerecha(reina, fila, col);
			chequearArriba(reina, fila, col);
			chequearAbajo(reina, fila, col);
			chequearDiagonales(reina, fila, col);
			
			System.out.println("REINA " + reina.getNumReina() + " CONFLICTO CON: ");
			for (Integer num : reina.getConflictoCon()) {
				System.out.println(num);
			}
			
			System.out.println("----------------");
		}
	}
	
	public void chequearIzquierda(Reina r, int fila, int col) {
		boolean found = false;
		//-1 para posicionarnos el casillero de la izq
		for (int i = col-1; i >= 0 && !found; i--) {
			if (this.tablero[fila][i] != 0) {
				r.addConflictoCon(this.tablero[fila][i]);
				found = true;
			}
		}
	}
	
	public void chequearDerecha(Reina r, int fila, int col) {
		boolean found = false;
		//+1 para posicionarnos el casillero de la der
		for (int i = col+1; i < this.dimension && !found; i++) {
			if (this.tablero[fila][i] != 0) {
				r.addConflictoCon(this.tablero[fila][i]);
				found = true;
			}
		}
	}

	public void chequearArriba(Reina r, int fila, int col) {
		boolean found = false;
		//-1 para posicionarnos el casillero de arriba
		for (int i = fila-1; i >= 0 && !found; i--) {
			if (this.tablero[i][col] != 0) {
				r.addConflictoCon(this.tablero[i][col]);
				found = true;
			}
		}
	}
	
	public void chequearAbajo(Reina r, int fila, int col) {
		boolean found = false;
		//+1 para posicionarnos el casillero de abajo
		for (int i = fila+1; i < this.dimension && !found; i++) {
			if (this.tablero[i][col] != 0) {
				r.addConflictoCon(this.tablero[i][col]);
				found = true;
			}
		}
	}
	
	public void chequearDiagonales(Reina r, int fila, int col) {
		boolean found = false;

		//Diagonal derecha superior
		for (int i = fila-1, j = col-1; i >= 0  && j >= 0 && !found; i--, j--) {
			if (this.tablero[i][j] != 0) {
				r.addConflictoCon(this.tablero[i][j]);
				found = true;
			}
		}
		
		found = false;
		//Diagonal derecha inferior
		for (int i = fila+1, j = col+1; i < this.dimension && j < this.dimension && !found; i++, j++) {
			if (this.tablero[i][j] != 0) {
				r.addConflictoCon(this.tablero[i][j]);
				found = true;
			}
		}
		
		found = false;
		//Diagonal izquierda inferior
		for (int i = fila+1, j = col-1; i < this.dimension && j >= 0 && !found; i++, j--) {
			if (this.tablero[i][j] != 0) {
				r.addConflictoCon(this.tablero[i][j]);
				found = true;
			}
		}
		
		found = false;
		//Diagonal izquierda superior
		for (int i = fila-1, j = col+1; i >= 0 && j < this.dimension && !found; i--, j++) {
			if (this.tablero[i][j] != 0) {
				r.addConflictoCon(this.tablero[i][j]);
				found = true;
			}
		}
	}
	
	
	public static Conflictos leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		Conflictos conf = new Conflictos(sc.nextInt());
		
		int cantReinas = sc.nextInt();
		
		for (int i = 0; i < cantReinas; i++) {
			Reina r = new Reina(i+1, sc.nextInt(), sc.nextInt());
			conf.tablero[r.getFila()-1][r.getColumna()-1] = i+1;
			conf.reinas.add(r);
		}
				
		
		sc.close();
		
		return conf;
	}
	
	
	
}
