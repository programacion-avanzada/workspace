package edu.unlam.progava.computandoPatentes;

public class Patente {
	String valor;
	private Conversor conversor;
	
	public Patente(String valor) {
		this.valor = valor;
		this.conversor = Conversor.getConversor(this);
	}

	public Patente getPatenteSiguiente(int n) {
		return conversor.getPatenteSiguiente(conversor.getNumero() + n);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Patente other = (Patente) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
