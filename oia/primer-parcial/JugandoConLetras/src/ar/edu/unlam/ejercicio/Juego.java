package ar.edu.unlam.ejercicio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Juego {
	
	private int dimension;
	private int cantPalabras;
	private String[] matrizE; //Iz - Der
	private String[] matrizO; //Der - Izq
	private String[] matrizS; //Arr - Aba
	private String[] matrizN; //Aba - Arr
	private String[] palabras;
		
	public static void main(String[] args) throws IOException {
		Juego jue = new Juego();
		
		jue.leerArchivo("entrada.in");
		jue.resolver();
			
	}
	
	public void leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		this.dimension = sc.nextInt();
		this.cantPalabras = sc.nextInt();
		//Lee el ultimo entero pero no salta de linea
		sc.nextLine();
		
		inicializarMatrices();
		this.palabras = new String[cantPalabras];		
		
		for (int i = 0; i < this.dimension; i++) {
			this.matrizE[i] = sc.nextLine();
		}
		
		for (int i = 0; i < this.cantPalabras; i++) {
			this.palabras[i] = sc.nextLine();
		}		
		
		sc.close();
		
		hallarOtrasMatrices();
	}
	
	public void inicializarMatrices() {
		this.matrizE = new String[dimension];
		this.matrizO = new String[dimension];
		this.matrizS = new String[dimension];
		this.matrizN = new String[dimension];
	}
	
	public void mostrarPalabras() {		
		for (int i = 0; i < this.cantPalabras; i++) {
			System.out.println(this.palabras[i]);
		}
	}
	
	public void hallarOtrasMatrices() {
		hallarMatrizO();
		hallarMatrizS();
		hallarMatrizN();
	}
	
	//Invierte las strings de la matrizE y las guarda
	public void hallarMatrizO() {
		  
		for (int i = 0; i < matrizE.length; i++) {
			StringBuilder rev = new StringBuilder(); 
			rev.append(matrizE[i]);
			rev = rev.reverse();
			matrizO[i] = new String(rev.toString());
		}
	}
	
	//Arr - Aba
	public void hallarMatrizS() {
		char arr[] = new char[dimension];
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				arr[j] = matrizE[j].charAt(i);
			}
			
			matrizS[i] = new String(arr);			
		}
	}
	
	//Aba - Arr
	public void hallarMatrizN() {
		char arr[] = new char[dimension];
		
		for (int i = 0; i < dimension; i++) {
			for (int j = dimension-1; j >= 0; j--) {
				arr[(dimension-1)-j] = matrizE[j].charAt(i);
			}
			
			matrizN[i] = new String(arr);			
		}
	}
	
	public void resolver() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("salida.out"));
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < cantPalabras; j++) {
				if (matrizE[i].contains(palabras[j])) {
					out.println(j+1 + " E");
				}
				
			}
		}
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < cantPalabras; j++) {
				if (matrizO[i].contains(palabras[j])) {
					out.println(j+1 + " O");
				}
				
			}
		}
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < cantPalabras; j++) {
				if (matrizN[i].contains(palabras[j])) {
					out.println(j+1 + " N");
				}
				
			}
		}
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < cantPalabras; j++) {
				if (matrizS[i].contains(palabras[j])) {
					out.println(j+1 + " S");
				}
				
			}
		}
		
		out.close();
	}
	
}
