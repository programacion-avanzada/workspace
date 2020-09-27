package ar.edu.unlam.vagones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Tren {
	
	private Animal animales[];
	private int cantVagones;
	private int agresividadMax; //Agresividad maxima a no superar
	private int agresividadMayor; //Mayor de las agresividades manejadas en comparacion con todos los vagones
	
	public Tren(Animal animales[], int agresMax) {
		this.animales = animales;
		this.agresividadMax = agresMax;
		this.cantVagones = 0;
		this.agresividadMayor = 0;
	}
	
	public static void main(String[] args) throws IOException {
		Tren trencito = leerArchivo("entrada.in");
		trencito.calcularVagonesMin();
		trencito.escribirArchivo("salida.out");
		trencito.hacerInnecesarioHomenajeALaSole();
	}
	
	public void calcularVagonesMin() {
		
		if (animales.length > 0) {
			//Si o si va a haber un vagon, al menos
			cantVagones++;
		
			//O(nlog(n))
			Arrays.sort(animales);
			
			//INDICE del primer animal del vagon
			int primAniVagon = 0;
			
			//O(n)
			for (int i = 1; i < animales.length; i++) {
				int difAgres = (animales[i].getAgresividad() - animales[primAniVagon].getAgresividad());
				
				if (difAgres >= this.agresividadMax) {
					cantVagones++;
					primAniVagon = i;
				} else {
					calcularAgresMax(difAgres);
				}				
			} 
		}
		
	}
	
	public void calcularAgresMax(int difAgres) {
		if (difAgres > agresividadMayor) {
			agresividadMayor = difAgres;
		}
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(this.cantVagones + " " + this.agresividadMayor);
		
		out.close();
	}
	
	public static Tren leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantEspecies = sc.nextInt(), agresMax = sc.nextInt();
		sc.nextLine();
		Animal vecAni[] = new Animal[cantEspecies];
				
		for (int i = 0; i < cantEspecies; i++) {
			vecAni[i] = new Animal(sc.next(), sc.nextInt());
			sc.nextLine();
		}
		
		sc.close();
		
		return new Tren(vecAni, agresMax);
	}
	
	public void hacerInnecesarioHomenajeALaSole() {
		System.out.println("Viajo por las nubes");
		System.out.println("Voy llevando mi overflow");
		System.out.println("Viajo por los cielos");
		System.out.println("Con las alas de mi compilador");
		System.out.println("Dejame que llegue");
		System.out.println("Que me está llamando el SUN (microsystems, rest in peace)");
		System.out.println("Vuelan los que pueden"); 
		System.out.println("Volar sin errores de compilación");
		System.out.println("Voy, voy llegando al SUN"); 
		System.out.println("Ven, que nos lleva el bytecode");
		System.out.println("Ahora voy, llevo mi overflow");
		System.out.println("Vooooooooooy, por el JVM");
	}
}
