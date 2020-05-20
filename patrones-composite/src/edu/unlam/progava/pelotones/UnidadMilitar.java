package edu.unlam.progava.pelotones;

public interface UnidadMilitar {
	public void moverse(double dx, double dy);
	public void atacar(UnidadMilitar objetivo);
	public void recibirAtaque();
}
