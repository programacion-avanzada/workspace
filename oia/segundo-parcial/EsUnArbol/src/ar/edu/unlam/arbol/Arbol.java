package ar.edu.unlam.arbol;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Arbol {
	
	private Grafo grafo;
	private int aristasEntrantes[];
	private boolean esArbol;
	private ArrayList<Integer> regla1;
	private ArrayList<Integer> regla2;
	private ArrayList<Integer> regla3; 
	
	public Arbol(Grafo grafo, int aristasEntrantes[]) {
		this.grafo = grafo;
		this.aristasEntrantes = aristasEntrantes;
		this.esArbol = true;
		this.regla1 = new ArrayList<Integer>();
		this.regla2 = new ArrayList<Integer>();
		this.regla3 = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) throws IOException {
		Arbol arb = leerArchivo("entrada.in");
		arb.resolver();
		arb.escribirArchivo("salida.out");
	
	}
	
	public void resolver() {

		
		for (int i = 0; i < aristasEntrantes.length; i++) {
			if (aristasEntrantes[i] == 0)
				regla1.add(i);
			if (aristasEntrantes[i] > 1)
				regla2.add(i);
		}
		
		if (regla1.size() == 1) {
			boolean visitado[] = grafo.DFS(regla1.get(0));
			
			for (int i = 0; i < visitado.length; i++) {
				if (visitado[i] == false) {
					regla3.add(i);
				}
			}
		}
		
		if (regla1.size() > 1 || regla1.size() == 0 || regla2.size() > 0 || regla3.size() > 0) 
			this.esArbol = false;
	}
	
	private void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));		
		
		if (!esArbol) {
			out.println("No");
			imprimirRegla(regla1, out);
			imprimirRegla(regla2, out);
			imprimirRegla(regla3, out);			
		} else
			out.println("Si");
		
		out.close();
		
	}
	
	public void imprimirRegla(ArrayList<Integer> regla, PrintWriter out) {
		if (regla.size() > 0) {
			for (Integer nodo : regla) {
				out.println(nodo + " ");
			}
		}
		else {
			out.println("0");
		}
	}
	
	
	public static Arbol leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantNodos = sc.nextInt(), cantAristas = sc.nextInt();
		int matriz[][] = new int[cantNodos][cantNodos];
		int aristasEntrantes[] = new int[cantNodos];
		
		for (int i = 0; i < cantAristas; i++) {
			int orig = sc.nextInt()-1, dest = sc.nextInt()-1;
			matriz[orig][dest] = 1;
			aristasEntrantes[dest]++;
		}
		
		sc.close();
		
		return new Arbol(new Grafo(matriz), aristasEntrantes);
	}

}
