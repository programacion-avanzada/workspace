package edu.unlam.progava.computandoPatentes;

public abstract class Conversor {
	protected final int VALOR_NUMERO_A_CHAR = 48;
	protected final int VALOR_LETRA_A_CHAR = 65;
	protected final int LETRAS = 26;
	protected final int NUMEROS = 10;

	protected final int CHAR_A_VALOR_NUMERO = -VALOR_NUMERO_A_CHAR;
	protected final int CHAR_A_VALOR_LETRA = -VALOR_LETRA_A_CHAR;
	protected final int LETRAS2 = LETRAS * LETRAS;
	protected final int LETRAS3 = LETRAS2 * LETRAS;
	protected final int NUMEROS2 = NUMEROS * NUMEROS;
	protected final int NUMEROS3 = NUMEROS2 * NUMEROS;
	
	protected Patente patente;

	public Conversor(Patente patente) {
		this.patente = patente;
	}
	
	public static Conversor getConversor(Patente patente) {
		Conversor conversor;
		if (patente.valor.length() == 6) {
			conversor = new Conversor1995(patente);
		} else {
			conversor = new Conversor2016(patente);
		}
		return conversor;
	}

	protected abstract long getNumero();

	protected abstract Patente getPatenteSiguiente(long n);
}
