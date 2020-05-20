package edu.unlam.progava.pelotones;

/*
 * Esta clase sirve para pruebas. Recuerda lo que le
 * sucede, para poder realizar aserciones sobre los
 * objetos que se creen de la misma.
 * Extiende el comportamiento de una clase del modelo,
 * pero agrega los suyos propios.
 */
public class UnidadStub extends Unidad {

	private int ataquesRecibidos;

	public UnidadStub(Punto posicion) {
		super(posicion);
	}
	
	@Override
	public void recibirAtaque() {
		this.ataquesRecibidos++;
	}

	public int getAtaquesRecibidos() {
		return this.ataquesRecibidos;
	}
}
