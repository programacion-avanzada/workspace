package ar.edu.unlam.colgantes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Movil {

	//Peso - Repeticiones
	private HashMap<Integer, Integer> colgantes;
	private int pesoTotal;
	private int cantVarillas;
	
	public Movil() {
		this.colgantes = new HashMap<Integer, Integer>();
		this.pesoTotal = 0;
		this.cantVarillas = 0;
	}
		
	public static void main(String[] args) throws IOException {
		Movil mov = leerArchivo("entrada.in");		
		mov.escribirArchivo("salida.out");
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		if (this.pesoTotal == 0) {
			out.println("No se puede");
		} else {
			out.println(this.pesoTotal + " " + this.cantVarillas);			
		}
		 
		out.close();
	}
	
	
	public static Movil leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
	
		int cantVarillas = sc.nextInt();		
		Movil mov = new Movil();		
				
		for (int i = 0; i < cantVarillas; i++) {
			int peso = sc.nextInt();
			Integer value = mov.colgantes.get(peso);
			
			//Si existe un colgante con ese peso, significa que ahora tenemos 2 colgantes, es decir
			//un par. Como nos interesa buscar los pares de colgantes, aumentamos los contadores
			//y después removemos al par
			if (value != null) {
				mov.pesoTotal += 2*peso;
				mov.cantVarillas++;
				mov.colgantes.remove(peso);
			} else {
				mov.colgantes.put(peso, 1);
			}
				
		}
		sc.close();		
		return mov;		
	}
}
