package edu.unlam.progava.chainofresponsibility;

public class Default extends Operacion {

	public void establecerSiguiente(Operacion siguiente) {
		throw new RuntimeException("No se puede agregar otro comportamiento");
	}

	public int calcular(Pedido pedido) {
		System.out.println("Intentando atender el pedido en Default");
		throw new RuntimeException("\"" + pedido.getTipoDeCalculo() + "\" no es un tipo de operación válida\n");
	}
	
	@Override
	public String toString() {
		return "Default";
	}
}
