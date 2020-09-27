package ar.edu.unlam.paiseslim;

import java.util.ArrayList;
import java.util.List;

public class Pais implements Comparable<Pais> {
	
	private String nombre;
	private List<Pais> limitaCon;
	
	public Pais(String nombre) {
		this.nombre = nombre;
		this.limitaCon = new ArrayList<Pais>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarPaisLimitrofe(Pais p) {
		this.limitaCon.add(p);
	}
	
	public void mostrarLimitrofes() {
		for (Pais p : limitaCon) {
			System.out.println(p.nombre);
		}
	}
	
	public List<Pais> getLimitaCon() {
		return limitaCon;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((limitaCon == null) ? 0 : limitaCon.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Pais other = (Pais) obj;
		/*if (limitaCon == null) {
			if (other.limitaCon != null)
				return false;
		} else if (!limitaCon.equals(other.limitaCon))
			return false;*/
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Pais other) {
		return this.nombre.compareTo(other.nombre);
	}
}
