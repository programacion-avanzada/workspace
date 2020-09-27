package ar.edu.unlam.cambio;

public class Arista {

	private int numCalle;
	private int origen;
	private int destino;
	private int costo;
	
	public Arista(int numCalle, int origen, int destino, int costo) {
		this.numCalle = numCalle;
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

	public int getNumCalle() {
		return numCalle;
	}

	public void setNumCalle(int numCalle) {
		this.numCalle = numCalle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costo;
		result = prime * result + destino;
		result = prime * result + numCalle;
		result = prime * result + origen;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		/*if (costo != other.costo)
			return false;*/
		if (destino != other.destino)
			return false;
		/*if (numCalle != other.numCalle)
			return false;*/
		if (origen != other.origen)
			return false;
		return true;
	}	
}
