package ar.edu.unlam.acorrer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Maraton {
	
	private Corredor corredores[];
	private Corredor ordLlegada[];
	private int matCatFem[][];
	private int matCatMas[][];
	private int matPodioCatFem[][];
	private int matPodioCatMas[][];
	
	
	public Maraton(int cantCorredores, int cantMeta, int cantCatF, int cantCatM) {
		this.corredores = new Corredor[cantCorredores];
		this.ordLlegada = new Corredor[cantMeta];
		this.matCatFem = new int[cantCatF][2];
		this.matCatMas = new int[cantCatM][2];
		this.matPodioCatFem = new int[cantCatF][4];
		this.matPodioCatMas = new int[cantCatM][4];
	}
	
	public static void main(String[] args) throws IOException {
		Maraton mar = leerArchivo("entrada.in");
		mar.resolver();
	}
	
	public void resolver() throws IOException {
		for (int i = 0; i < ordLlegada.length; i++) {
			if (ordLlegada[i].getSexo() == 'F') {
				agregarAPodio(matCatFem, matPodioCatFem, ordLlegada[i]);
			}
			else {
				agregarAPodio(matCatMas, matPodioCatMas, ordLlegada[i]);
			}
		}
		
		escribirPodios("salida.out");
	}
	
	public void agregarAPodio(int matCat[][], int matPodio[][], Corredor cor) {
		boolean encontrado = false;
		for (int j = 0; j < matCat.length && !encontrado; j++) {
			if (cor.getEdad() >= matCat[j][0] && cor.getEdad() <= matCat[j][1]) {
				int posPodio = matPodio[j][3];
				matPodio[j][posPodio] = cor.getNumInscrip();
				matPodio[j][3] += 1;
				encontrado = true;
			}
		}
	}
	
	public void escribirPodios(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		for (int i = 0; i < matPodioCatFem.length; i++) {		
			out.print(i+1);
			out.print(' ');
			for (int j = 0; j < 3; j++) {
				out.print(matPodioCatFem[i][j]);
				out.print(' ');
			}
			out.println();
		}
		
		for (int i = 0; i < matPodioCatMas.length; i++) {		
			out.print(i+1);
			out.print(' ');
			for (int j = 0; j < 3; j++) {
				out.print(matPodioCatMas[i][j]);
				out.print(' ');
			}
			out.println();
		}
		
		out.close();		
	}	
	
	public static Maraton leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantCorredores, cantCatF, cantCatM, cantMeta; 
		
		cantCorredores = sc.nextInt();
		cantCatF = sc.nextInt();
		cantCatM = sc.nextInt();
		cantMeta = sc.nextInt();
		
		Maraton mar = new Maraton(cantCorredores, cantMeta, cantCatF, cantCatM);
		
		//Leemos el rango de edades de las categorías femeninas
		for (int i = 0; i < cantCatF; i++) {
			mar.matCatFem[i][0] = sc.nextInt();
			mar.matCatFem[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < cantCatM; i++) {
			mar.matCatMas[i][0] = sc.nextInt();
			mar.matCatMas[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < cantCorredores; i++) {
			Corredor cor = new Corredor(i+1, sc.nextInt(), sc.next().charAt(0));
			mar.corredores[i] = cor;			
		}
		
		for (int i = 0; i < cantMeta; i++) {
			mar.ordLlegada[i] = mar.corredores[sc.nextInt()-1];
		}		
		
		sc.close();		
		
		return mar;		
	}	
}
