package computando_patentes;

public abstract class Conversor {

	public static Conversor getConversor(String patente) {
		Conversor c;
		if (patente.length() == 6) {
			c = new Conversor1995();
		} else {
			c = new Conversor2016();
		}
		return c;
	}

	protected abstract long getNumero(String patente);

	protected abstract String getPatente(long n);
}
