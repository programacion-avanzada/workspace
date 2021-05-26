package edu.unlam.progava.chainofresponsibility;

public class Sumar extends Operacion {

	public int calcular(Pedido pedido) {
		System.out.println("Intentando atender el pedido en Sumar");
		if (pedido.getTipoDeCalculo().equals("sumar")) {
			int resultado = pedido.getNumero1() + pedido.getNumero2();
			System.out.print(pedido.getNumero1() + " + " + pedido.getNumero2());
			System.out.print(" = " + resultado + "\n");

			return resultado;
		} else {
			System.out.println("No puedo atenderlo, pasando al " + siguiente);
			return siguiente.calcular(pedido);
		}
	}

	@Override
	public String toString() {
		return "Sumar";
	}

}
