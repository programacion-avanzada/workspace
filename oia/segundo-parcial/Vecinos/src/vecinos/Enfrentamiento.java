package vecinos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


//			|\---/|
//			| ,_, |
//			 \_`_/-..----.
//			___/ `   ' ,""+ \  
//			(__...'   __\    |`.___.';
//			(_,...'(_,.`__)/'.....+
//
//			NO REMOVER AL GATO, APARENTEMENTE EL CODIGO NO ANDA SIN EL GATO

public class Enfrentamiento {
	
	private Grafo grafo;
	private int priOponente;
	private int segOponente;
	private int aliadosX;
	private int aliadosY;

	
	public Enfrentamiento(Grafo grafo, int pri, int seg) {
		this.grafo = grafo;
		this.priOponente = pri;
		this.segOponente = seg;

	}
	
	public static void main(String[] args) throws IOException {
		Enfrentamiento enf = leerArchivo("vecinos5.in");
		enf.resolver();
		enf.escribirArchivo("vecinos5.out");
	}
	
	public void resolver() {
		//Realizamos un BFS para obtener todas las cadenas vistas desde el vecino X, hacia todos los nodos
		//(con obvias excepciones tales como las cadenas que pasen por el oponente, o aquellas que se formen consigo mismo) 
		ArrayList<Nodo> cadenasDesdeX = grafo.BFS(priOponente, segOponente);
		ArrayList<Nodo> cadenasDesdeY = grafo.BFS(segOponente, priOponente);
		
		//Buscamos la cadena máxima por cada uno de los nodos, para ambas listas de nodos
		hallarCadenasMaximasPorNodo(cadenasDesdeX);
		hallarCadenasMaximasPorNodo(cadenasDesdeY);
				
		//Ejecutamos un ciclo que recorra todos los nodos de las listas
		for (int i = 0; i < grafo.getCantNodos(); i++) {
			if (i != priOponente && i != segOponente) {
				//Si las dos cadenas existen, debemos decidir a quien pertenece el aliado
				if(cadenasDesdeX.get(i).getCadenaMax() != null && cadenasDesdeY.get(i).getCadenaMax() != null) {
					if (cadenasDesdeX.get(i).getCadenaMax().getValor() > cadenasDesdeY.get(i).getCadenaMax().getValor()) {
						aliadosX++;
					} else if (cadenasDesdeX.get(i).getCadenaMax().getValor() < cadenasDesdeY.get(i).getCadenaMax().getValor()){
						aliadosY++;
					}
				}
				//En cambio si una de las cadenas no existe y la otra sí, debemos ver a qué aliado pertenece esa cadena
				else {
					//Si la cadena existente es la del vecino Y... le sumamos un aliado
					if(cadenasDesdeX.get(i).getCadenaMax() == null && cadenasDesdeY.get(i).getCadenaMax() != null)
						aliadosY++;
					//Si no, le sumamos un aliado al vecino X
					else if (cadenasDesdeX.get(i).getCadenaMax() != null && cadenasDesdeY.get(i).getCadenaMax() == null)
						aliadosX++;
				}
			}
		}
	}
	
	public void hallarCadenasMaximasPorNodo(ArrayList<Nodo> nodos) {
		for (Nodo nodo : nodos) {			
			if (nodo.getCadenas().size() > 0) {
				Cadena cadMax = nodo.getCadenas().get(0);						
			
				for (Cadena cad : nodo.getCadenas()) {
					if (cad.getValor()> cadMax.getValor()) 
						cadMax = cad;
					
				}				
				nodo.setCadenaMax(cadMax);
			}			
		}
	}
	
	public static Enfrentamiento leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantVecinos = sc.nextInt(), cantLazos = sc.nextInt();
		int pri = sc.nextInt()-1, seg = sc.nextInt()-1;
		
		int matrizAdy[][] = new int[cantVecinos][cantVecinos];
		
		//Creamos la matriz de adyacencia
		for (int i = 0; i < cantLazos; i++) {
			int nodoOrig = sc.nextInt()-1, nodoDest = sc.nextInt()-1, costo = sc.nextInt();
			matrizAdy[nodoOrig][nodoDest] = costo;
			matrizAdy[nodoDest][nodoOrig] = costo;
		}
		
		sc.close();
		
		return new Enfrentamiento(new Grafo(matrizAdy), pri, seg);	
	}
	
	public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		out.println(aliadosX + " " + aliadosY);
		
		out.close();		
	}
}
