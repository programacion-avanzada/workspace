package ar.edu.unlam.formandoequipos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class Preguntas {
	
	private int cantColab; //Cantidad de colaboradores en el grupo
	private int cantPreguntas; //Cantidad de preguntas iguales (empezando desde la primera)
	private String respuestas[]; //String que contiene las respuestas
	private HashMap <String, Integer> equipos;
	
	public Preguntas (int cantPreguntas, int cantColab, String respuestas[])
	{
		this.cantPreguntas = cantPreguntas;
		this.cantColab = cantColab;
		this.respuestas = respuestas;
		this.equipos = new HashMap<String, Integer>();
	}

	public static void main(String[] args) throws IOException {			
		Preguntas preg = leerArchivo("entrada.in");
		
		preg.resolver();
		preg.escribirArchivoSalida("salida.out");
		System.out.println(preg.equipos.size());
	}
	
	public void resolver() {		
		
		//O(P*C) --> P = cantPreguntas, C = cantColaboradores
		for (int i = 0; i < cantPreguntas; i++) {
			String resp = respuestas[0].substring(0, i+1);
			Equipo equi = new Equipo();
			
			//O(C)
			for (int j = 0; j < cantColab; j++) {
				if (resp.equals(respuestas[j].substring(0, i+1))) {
					equi.aumentarCantColab();
				} else {
					agregarEquipo(equi, i, j);
										
					equi = new Equipo();
					equi.aumentarCantColab();
					resp = respuestas[0].substring(0, i+1);
				}				
			}	
			
			agregarEquipo(equi, i, cantColab);	
			//O(C), peor de los casos (equipos individuales)
			removerEquiposMenorAfinidad();			
		}
	}
	
	public void agregarEquipo(Equipo equi, int i, int j) {
		equi.setCantRespIguales(i+1);
		equi.setRespuestas(respuestas[j-1].substring(0, i+1));
		
		Integer value = equipos.get(equi.getRespuestas());
		
		if (value == null) {
			equipos.put(equi.getRespuestas(), equi.getCantColab());
		} else {
			equipos.put(equi.getRespuestas(), value+1);
		}
	}
	
	
	public void removerEquiposMenorAfinidad() {
		if (equipos.size() < 2) 
			return;
		
		int max = -1;
		int value = 0;
		String str = new String();
		
		for (Entry<String,Integer> entry : equipos.entrySet()) {
			int afinidad = (int) (entry.getValue()*Math.pow(entry.getKey().length(), 2));
			if (afinidad >= max) {
				str = entry.getKey();
				value = entry.getValue();
				max = afinidad;
			}
		}
		
		equipos.clear();
		equipos.put(str, value);
	}
	
	public static Preguntas leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantPreguntas = sc.nextInt();
		int cantColab = sc.nextInt();
		//Avanzamos una línea extra, porque nextInt no lee el newline character del final, nos quedamos atrasados una linea
		sc.nextLine();
		
		String respuestas[] = new String[cantColab];
		
		for (int i = 0; i < cantColab; i++) {			
			respuestas[i] = sc.nextLine(); 
		}	
		
		sc.close();
		
		return new Preguntas(cantPreguntas, cantColab, respuestas);
		
	}
	
	
	public void escribirArchivoSalida(String path) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(path));
		
		for (Entry<String,Integer> entry : equipos.entrySet()) { 
			int afinidad = (int) (entry.getValue()*Math.pow(entry.getKey().length(), 2));
			
			salida.println(afinidad);
			salida.println(entry.getKey());
		}
		
		
		salida.close();
	}
}
