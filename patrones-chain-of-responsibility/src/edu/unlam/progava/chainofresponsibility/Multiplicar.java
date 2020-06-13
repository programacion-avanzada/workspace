package edu.unlam.progava.chainofresponsibility;

public class Multiplicar implements Operacion {

	private Operacion siguiente;


	public void establecerSiguiente(Operacion siguiente) {
		this.siguiente = siguiente;
	}

	public int calcular(Pedido pedido) {

		if (pedido.getTipoDeCalculo().equals("multiplicar")) {
			int resultado = pedido.getNumero1() * pedido.getNumero2();
			System.out.print(pedido.getNumero1() + " * " + pedido.getNumero2());
			System.out.print(" = " + resultado + "\n");

			return resultado;
		} else {
			System.out.println("No puedo atenderlo, pasando al " + siguiente);
			return siguiente.calcular(pedido);
		}

	}

	@Override
	public String toString() {
		return "Multiplicar";
	}

}
