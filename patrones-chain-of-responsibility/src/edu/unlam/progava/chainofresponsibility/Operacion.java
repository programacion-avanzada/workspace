package edu.unlam.progava.chainofresponsibility;

public interface Operacion {

	public void establecerSiguiente(Operacion siguiente);

	public int calcular(Pedido pedido);

}
