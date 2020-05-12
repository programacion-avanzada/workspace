package computandoPatentes;

public class Patente {
	String valor;

	public Patente(String valor) {
		this.valor = valor;
	}

	public String getPatenteSiguiente(int n) {
		Conversor conversor = Conversor.getConversor(this);
		long patenteNumero = conversor.getNumero(this);
		return conversor.getPatente(patenteNumero + n);
	}
}
