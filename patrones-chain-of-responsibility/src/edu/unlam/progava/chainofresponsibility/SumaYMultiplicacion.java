package edu.unlam.progava.chainofresponsibility;

public class SumaYMultiplicacion implements Operacion {

	private Operacion siguiente;


	public void establecerSiguiente(Operacion siguiente) {
		this.siguiente = siguiente;
	}

	public int calcular(Pedido pedido) {
		
		if (pedido.getTipoDeCalculo().equals("sym")) {
			Sumar s = new Sumar();
			Multiplicar m = new Multiplicar();
			
			int resultado = s.calcular(new Pedido("sumar", pedido.getNumero1(), pedido.getNumero2()));
			System.out.println(" + ");
			resultado += m.calcular(new Pedido("multiplicar", pedido.getNumero1(), pedido.getNumero2())); 

			return resultado;
					
		} else {
			System.out.println("No puedo atenderlo, pasando al " + siguiente);
			return siguiente.calcular(pedido);
		}
		
	}

	@Override
	public String toString() {
		return "Sumar y Multiplicar";
	}

}
