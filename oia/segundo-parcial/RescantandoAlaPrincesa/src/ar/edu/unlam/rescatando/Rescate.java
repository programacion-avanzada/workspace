package ar.edu.unlam.rescatando;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Rescate {
	private int dragones[];
	private int claroPrincipe;
	private int claroPrincesa;
	private Grafo grafo;
	private String salida;
		
	public Rescate(int cantClaros, int cantSenderos, int dragones[], int claroPrincesa, int claroPrincipe, int mat[][]) {
		this.dragones = dragones;
		this.claroPrincesa = claroPrincesa;
		this.claroPrincipe = claroPrincipe;
		this.grafo = new Grafo(mat);		
	}
	
	public static void main(String[] args) throws IOException {
		Rescate res = leerArchivo("entrada.in");
		res.resolver();	
		res.escribirArchivo("salida.in");
	}
		
	public void resolver() {
		//Caminos mas cortos hacia los claros vistos desde la princesa
		int[] distPrincesa = grafo.dijkstra(this.claroPrincesa-1); 
		
		int distPrincipe = distPrincesa[this.claroPrincipe-1];
		this.salida = "";
		
		if (distPrincipe == 0) {
			this.salida = "NO HAY CAMINO";
			return;
		} else {
			for (int i = 0; i < dragones.length; i++) {
				//Si hay un dragon que se encuentra a una distancia mas corta o igual a la del principe
				if (distPrincesa[dragones[i]-1] > 0 && distPrincesa[dragones[i]-1] <= distPrincipe) {
					this.salida = "INTERCEPTADO";
					return;
				}				
			}
			
			//Si no se interceptó al principito
			System.out.println("PINTAME UN CORDEROOOOOOOOOOOOOOOOOOOOOOOOOO");
			ArrayList<Integer> camino = grafo.getCamino(claroPrincipe-1);
			for (int i = 0; i < camino.size(); i++) {
				this.salida += (camino.get(i) + 1) + " ";
			}
		}	
	}	
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(salida);
		
		out.close();
	}
	
	public static Rescate leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantC = sc.nextInt(), cantS = sc.nextInt();
		int dragones[] = new int[sc.nextInt()];
		int cf = sc.nextInt(), cm = sc.nextInt();
				
		for (int i = 0; i < dragones.length; i++) {
			dragones[i] = sc.nextInt();
		}
		
		int matriz[][] = new int[cantC][cantC];
		
		//Tenemos que guardar la cantidad de conexiones que hay
		//es decir, los senderos, las aristas
		for (int i = 0; i < cantS; i++) {
			//Les restamos 1 porque la matriz comienza desde 0
			int claroIni = sc.nextInt()-1, claroFin = sc.nextInt()-1, peso = sc.nextInt();
			
			matriz[claroIni][claroFin] = peso;
			matriz[claroFin][claroIni] = peso;			
		}		
		
		sc.close();
		
		return new Rescate(cantC, cantS, dragones, cf, cm, matriz);
	}
	

}
