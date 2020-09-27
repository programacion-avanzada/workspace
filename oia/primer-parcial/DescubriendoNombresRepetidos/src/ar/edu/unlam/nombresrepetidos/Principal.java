package ar.edu.unlam.nombresrepetidos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Principal {
	
	private int cantFrec;
	private int cantNombres;
	private HashMap<String, Integer> mapNombres;
	private TreeMap<Integer, String> mapOrdenado;
	private String[] nombres;
	//private Nombre[] nombresFrecuentes;
	
	public Principal(int cantNombres, int cantFrec) {
		this.cantFrec = cantFrec;
		this.cantNombres = cantNombres;
		this.nombres = new String[cantNombres];
		this.mapNombres = new HashMap<String, Integer>();
		this.mapOrdenado = new TreeMap<Integer, String>();
		//this.nombresFrecuentes = new Nombre[cantFrec];
	}
	
	public static void main(String[] args) throws IOException {
		Principal prin = leerArchivo("entrada.in");
		
		prin.resolver();
		//prin.escribirArchivo("salida.out");
	}
	
	public void resolver() throws IOException {
		//O(n*log(n)) --> quicksort
		//Arrays.sort(nombres);
		//inicializarArray();
		
		//int cont = 0;
		//O(n) en el peor de los casos (sin nombres repetidos, recorriendo uno por uno)
		//En realidad es O(n) en todos los casos, porque si bien nos "salteamos" los repetidos, estamos
		//recorriendolos uno por uno dentro del otro ciclo for
		for (int i = 0; i < cantNombres; i++) {
			//cont = 0;
			
			Integer value = mapNombres.get(nombres[i]);
			
			if (value != null) {
				mapNombres.put(nombres[i], value + 1);
			} else {
				mapNombres.put(nombres[i], 1);
			}
						
			/*for (int j = i; j < nombres.length && nombres[i].equals(nombres[j]); j++) {
				cont++;
			}*/
			
			//Nombre nom = new Nombre(nombres[i], cont);			
			//O(nlog(n))
			//agregarAFrecuencia(nom);
		}
		obtenerNombresRepetidos("salida.out");
	}
	
	public void obtenerNombresRepetidos(String path) throws IOException {
		for(Entry<String, Integer> nombre : mapNombres.entrySet()) {
			mapOrdenado.put(nombre.getValue(), nombre.getKey());
		}
		
		PrintWriter out = new PrintWriter(new FileWriter(path));
				
		for (int k = 1; k <= cantFrec; k++) {
			Entry<Integer, String> salida = mapOrdenado.pollLastEntry();
			out.println(salida.getValue() + " " + salida.getKey());
		}
		
		out.close();
	}
	
	/*public void inicializarArray() {
		for (int i = 0; i < nombresFrecuentes.length; i++) {
			nombresFrecuentes[i] = new Nombre("", 0);
		}
	}*/
	
	/*public void agregarAFrecuencia(Nombre nombre) {		
		//Si la frecuencia es menor que la minima de todas las frec, ni nos gastamos en revisar
		if (nombresFrecuentes[0] != null && nombre.getFrecuencia() <= nombresFrecuentes[0].getFrecuencia())
			return;
		//Añadimos la frecuencia en la ultima posición
		nombresFrecuentes[0] = nombre;
		
		//Arrays.sort SOLO ordena en orden ascendente... debido a esto tenemos que tener
		//especial precaucion al momento de listar la frecuencia de nombres (es decir, vamos a tener
		//que recorrer el array en orden inverso para mostrarlos en orden descendente)
		Arrays.sort(nombresFrecuentes);		
	}*/
	
	/*public void escribirArchivo(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
				
		for (int i = nombresFrecuentes.length-1; i >= 0; i--) {
			out.println(nombresFrecuentes[i].getNombre() + " " + nombresFrecuentes[i].getFrecuencia());
		}
		
		out.close();	
	}*/
	
	public static Principal leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantChicos =  sc.nextInt(), frec = sc.nextInt();
		//Leemos hasta la prox. linea porque nextInt no nos lleva a la prox
		sc.nextLine();
		
		Principal prin = new Principal(cantChicos, frec);
		
		for (int i = 0; i < cantChicos; i++) {
			prin.nombres[i] = sc.nextLine();
		}

		sc.close();
		return prin;
	}

}
