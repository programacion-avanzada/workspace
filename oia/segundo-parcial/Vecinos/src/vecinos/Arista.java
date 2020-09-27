package vecinos;

public class Arista {
	
	/** 
	 * La clase Arista es una clase que simplemente se encarga de representar, en codigo, lo que es una arista.
	 * Posee un nodo origen, un nodo destino, y el costo/peso de la arista en sí.
	 * 
	 */
	
	private int origen;
	private int destino;
	private int costo;
	
	public Arista (int origen, int destino, int costo) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	
}