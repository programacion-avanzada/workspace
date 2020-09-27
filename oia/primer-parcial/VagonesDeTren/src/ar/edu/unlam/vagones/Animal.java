package ar.edu.unlam.vagones;

public class Animal implements Comparable<Animal> {

	private String nombre;
	private int agresividad;
	
	public Animal(String nombre, int agresividad) {
		this.nombre = nombre;
		this.agresividad = agresividad;
	}	
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAgresividad() {
		return agresividad;
	}

	public void setAgresividad(int agresividad) {
		this.agresividad = agresividad;
	}

	@Override
	public int compareTo(Animal ani) {
		if (this.agresividad < ani.agresividad)
			return -1;
		else if (this.agresividad > ani.agresividad)
			return 1;
		return 0;
	}
}
