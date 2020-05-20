package chainOfResponsibility;

public interface Operacion {

	public void establecerSiguiente(Operacion siguiente);

	public int calcular(Pedido pedido);

}
