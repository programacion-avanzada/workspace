package ar.edu.unlam.numpeque;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Principal {
	
	private int cantPeque;
	private TreeSet<Integer> numeros; 

	
	public Principal(int cantPeque) {
		this.cantPeque = cantPeque;
		this.numeros = new TreeSet<Integer>();
	}
	
	public static void main(String[] args) throws IOException {
		Principal prin = leerArchivo("entrada.in");
		
		prin.resolver();		
	}
	
	public void resolver() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("salida.out"));
		
		out.println(cantPeque);
		for (int i = 0; i < cantPeque; i++) {
			out.println(numeros.pollFirst());
		}
		
		out.close();
	}
		
	public static Principal leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantTotal = sc.nextInt(), cantPeque = sc.nextInt();
		//Avanzamos a la proxima linea
		sc.nextLine();
		
		Principal prin = new Principal(cantPeque);
		
		for (int i = 0; i < cantTotal; i++) {
			prin.numeros.add(sc.nextInt());
		}
		
		sc.close();
		
		return prin;
	}
	

}
