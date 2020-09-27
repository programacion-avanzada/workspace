package ar.edu.unlam.acortando;

public class Arista {

	private int numArista;
	private int orig;
	private int dest;
	private int costo;
	
	public Arista(int num, int orig, int dest, int costo) {
		this.numArista = num;
		this.orig = orig;
		this.costo = costo;
		this.dest = dest;
	}

	public int getOrig() {
		return orig;
	}

	public void setOrig(int orig) {
		this.orig = orig;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getNumArista() {
		return numArista;
	}

	public void setNumArista(int numArista) {
		this.numArista = numArista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costo;
		result = prime * result + dest;
		result = prime * result + numArista;
		result = prime * result + orig;
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
		if (dest != other.dest)
			return false;
		/*if (numArista != other.numArista)
			return false;*/
		if (orig != other.orig)
			return false;
		return true;
	}
	
	
	
}
