package edu.unlam.progava.chainofresponsibility;

public abstract class Operacion {

	protected Operacion siguiente;

	public void establecerSiguiente(Operacion siguiente) {
		this.siguiente = siguiente;
	}

	public abstract int calcular(Pedido pedido);

}
