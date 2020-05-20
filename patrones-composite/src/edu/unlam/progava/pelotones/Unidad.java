package edu.unlam.progava.pelotones;

public class Unidad implements UnidadMilitar {

	private Punto posicion;
	
	public Unidad(Punto posicion) {
		this.posicion = posicion;
	}
	
	public void recibirAtaque() {
		// restar salud, por ejemplo
	}
	
	public Punto getPosicion() {
		return posicion;
	}
	
	public void moverse(double dx, double dy) {
		this.posicion = this.posicion.desplazarse(dx, dy);
	}
	
	@Override
	public String toString() {
		return "u:" + posicion.toString();
	}

	@Override
	public void atacar(UnidadMilitar objetivo) {
		objetivo.recibirAtaque();
	}
	
}
