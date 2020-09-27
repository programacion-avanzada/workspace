package ar.edu.unlam.tenisrecargado;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {

	private int cantJuegos;
	private int cantSets;
	private int cantMinJuegos;
	private int difNecesaria;
	private Jugador jugA;
	private Jugador jugB;
	
	public Principal(int cantJ, int cantS, int cantMinJ, int difN) {
		this.cantJuegos = cantJ;
		this.cantSets = cantS;
		this.cantMinJuegos = cantMinJ;
		this.difNecesaria = difN;
		this.jugA = new Jugador();
		this.jugB = new Jugador();
	}
	
	public static void main(String[] args) throws IOException {
		Principal prin = leerArchivo("entrada.in");		
		prin.escribirArchivo("salida.out");
	} 	
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(this.jugA.getSetsGanados() + " " + this.jugB.getSetsGanados());
		out.close();
	}
		
	
	public static Principal leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		Principal prin = new Principal(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		sc.nextLine();
		
		String cantJuegos = sc.next();
		int jugA = 0, jugB = 0;
		int setA = 0, setB = 0;		
		
		for (int i = 0; i < prin.cantJuegos; i++) {						
			//Calculamos la cantidad de juegos que ganaron dentro de un set
			if (cantJuegos.charAt(i) == 'A') {				
				jugA++;
			}
			else {
				jugB++;
			}			

			int difA = jugA-jugB, difB = jugB-jugA;			
			
			if (jugA >= prin.cantMinJuegos && difA >= prin.difNecesaria) {
				setA++;
				jugA = jugB = 0;
			} else if (jugB >= prin.cantMinJuegos && difB >= prin.difNecesaria) {
				setB++;
				jugA = jugB = 0;
			} 
		}	
		
		prin.jugA.setSetsGanados(setA);
		prin.jugB.setSetsGanados(setB);
		
		sc.close();
		return prin;		
	}
}
