package edu.unlam.progava.chainofresponsibility;

public class Default implements Operacion {

	public void establecerSiguiente(Operacion siguiente) {
		throw new RuntimeException("No se puede agregar otro comportamiento");
	}

	public int calcular(Pedido pedido) {
		throw new RuntimeException("\"" + pedido.getTipoDeCalculo() + "\" no es un tipo de operación válida\n");
	}
	
	@Override
	public String toString() {
		return "Default";
	}
}
