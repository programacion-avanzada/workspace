package ar.edu.unlam.nombresrepetidos;

public class Nombre implements Comparable<Nombre> {
	
	private String nombre;
	private int frecuencia;
	
	public Nombre(String nombre, int frecuencia) {
		this.nombre = nombre;
		this.frecuencia = frecuencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	@Override
	public int compareTo(Nombre o) {
		if (this.frecuencia < o.frecuencia)
			return -1;
		else if (this.frecuencia > o.frecuencia)
			return 1;		
		
		return 0;		
	}



}
