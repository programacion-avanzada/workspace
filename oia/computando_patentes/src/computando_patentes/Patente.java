package computando_patentes;

public class Patente {
	String patente;

	public Patente(String patente) {
		this.patente = patente;
	}

	public String getPatenteSiguiente(int n) {
		Conversor conversor = Conversor.getConversor(patente);
		long patenteNumero = conversor.getNumero(patente);
		return conversor.getPatente(patenteNumero + n);
	}
}
