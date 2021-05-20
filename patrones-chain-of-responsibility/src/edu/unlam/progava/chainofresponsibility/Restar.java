package edu.unlam.progava.chainofresponsibility;

public class Restar extends Operacion {

	public int calcular(Pedido pedido) {
		System.out.println("Intentando atender el pedido en Restar");
		if (pedido.getTipoDeCalculo().equals("restar")) {
			int resultado = pedido.getNumero1() - pedido.getNumero2();
			System.out.print(pedido.getNumero1() + " - " + pedido.getNumero2());
			System.out.print(" = " + resultado + "\n");

			return resultado;
		} else {
			System.out.println("No puedo atenderlo, pasando al " + siguiente);
			return siguiente.calcular(pedido);
		}

	}

	@Override
	public String toString() {
		return "Restar";
	}

}
