package ar.edu.unlam.imagen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Imagen {

	private String aComprimir;
	private String aDescomprimir;
	private String descomprimida;
	private String comprimida;
	
	public static void main(String[] args) throws IOException {
		Imagen img = leerArchivo("entrada.in");
		img.comprimir();
		img.descomprimir();
		img.escribirArchivo("salida.out");
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(this.comprimida);
		out.println(this.descomprimida);		
		out.close();
	}	
	
	public void comprimir() {
		StringBuilder str = new StringBuilder();
		char actual = this.aComprimir.charAt(0);
		int repeticiones = 1;
		
		//O(n*3)
		for (int i = 1; i < this.aComprimir.length(); i++) {
			if (this.aComprimir.charAt(i) != actual) {
				if (repeticiones > 4) {
					agregarFormatoComprimido(str, actual, repeticiones);
				}				
				else {
					agregarVarios(str, actual, repeticiones);
				}
				repeticiones = 1;
				actual = this.aComprimir.charAt(i); 
			} else {
				repeticiones++;
			}
		}
		
		this.comprimida = str.toString();
	}
	
	public void agregarFormatoComprimido(StringBuilder strB, char letra, int repe) {
		String str = "("+letra+repe+")";
		strB.append(str);		
	}
	
	public void agregarVarios(StringBuilder str, char letra, int repe) {
		for (int i = 0; i < repe; i++) {
			str.append(letra);
		}
	}
	
	public void descomprimir() {
		StringBuilder str = new StringBuilder();
		
		//O(n*m) 
		//m = cant. de veces repetidas
		for (int i = 0; i < this.aDescomprimir.length(); i++) {
			if (this.aDescomprimir.charAt(i) == '(') {
				i++;
				char letra = this.aDescomprimir.charAt(i);
				i++;
				StringBuilder num = new StringBuilder();
				
				while (this.aDescomprimir.charAt(i) != ')') {
					num.append(aDescomprimir.charAt(i));
					i++;
				}
				
				agregarVarios(str, letra, Integer.parseInt(num.toString()));
			} else {
				str.append(this.aDescomprimir.charAt(i));
			}
		}
		
		this.descomprimida = str.toString();
	}
	
	public static Imagen leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		Imagen img = new Imagen();
		
		img.aComprimir = sc.nextLine();
		img.aDescomprimir = sc.nextLine();
		
		sc.close();
		return img;
	}	
}
