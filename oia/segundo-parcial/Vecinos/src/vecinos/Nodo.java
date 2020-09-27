package vecinos;

import java.util.ArrayList;

public class Nodo {

	/**
	 * La clase nodo contiene un atributo que indica el número del nodo (que usamos como identificador),
	 * Una lista de cadenas, y la cadena de valor máximo.
	 * 
	 * La lista de cadenas representa a todas las posibles cadenas que pueden armarse hacia este nodo, saliendo
	 * desde un nodo origen determinado. El sentido de la cadena es: NodoOrigen ---> NodosIntermedios ---> NooDestino
	 * con esto queremos decir que, este nodo puntual no guarda cadenas que vayan en otra dirección, o cadenas que se 
	 * formen yendo hacia otros nodos.
	 * 
	 * La cadenaMax es la cadena cuyo valor es superior al de todas las cadenas que van hacia este nodo. 
	 * 
	 */
	
	
	private int numNodo;
	private ArrayList<Cadena> cadenas;
	private Cadena cadenaMax;
	
	public Nodo (int nodo) {
		this.numNodo = nodo;
		cadenas = new ArrayList<Cadena>();
	}

	public int getNumNodo() {
		return numNodo;
	}

	public void setNumNodo(int numNodo) {
		this.numNodo = numNodo;
	}

	public ArrayList<Cadena> getCadenas() {
		return cadenas;
	}

	public void setCadenas(ArrayList<Cadena> recorridos) {
		this.cadenas = recorridos;
	}

	public Cadena getCadenaMax() {
		return cadenaMax;
	}

	public void setCadenaMax(Cadena cadenaMax) {
		this.cadenaMax = cadenaMax;
	}
	
}
