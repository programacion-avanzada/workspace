package edu.unlam.progava.patentes;

public class Conversor1995 extends Conversor {

	public Conversor1995(Patente patente) {
		super(patente);
	}

	@Override
	protected long getNumero() {
		char[] simbolos = patente.valor.toCharArray();
		long numerico = 0;
		numerico += (simbolos[5] + CHAR_A_VALOR_NUMERO);
		numerico += (simbolos[4] + CHAR_A_VALOR_NUMERO) * NUMEROS;
		numerico += (simbolos[3] + CHAR_A_VALOR_NUMERO) * NUMEROS2;
		numerico += (simbolos[2] + CHAR_A_VALOR_LETRA) * NUMEROS3;
		numerico += (simbolos[1] + CHAR_A_VALOR_LETRA) * NUMEROS3 * LETRAS;
		numerico += (simbolos[0] + CHAR_A_VALOR_LETRA) * NUMEROS3 * LETRAS2;
		return numerico;
	}

	@Override
	protected Patente getPatenteSiguiente(final long _numerico) {
		char[] simbolos = new char[6];
		long numerico = _numerico;

		simbolos[0] = (char) (numerico / (NUMEROS3 * LETRAS2) + VALOR_LETRA_A_CHAR);
		numerico %= NUMEROS3 * LETRAS2;
		simbolos[1] = (char) (numerico / (NUMEROS3 * LETRAS) + VALOR_LETRA_A_CHAR);
		numerico %= NUMEROS3 * LETRAS;
		simbolos[2] = (char) (numerico / NUMEROS3 + VALOR_LETRA_A_CHAR);
		numerico %= NUMEROS3;
		simbolos[3] = (char) (numerico / NUMEROS2 + VALOR_NUMERO_A_CHAR);
		numerico %= NUMEROS2;
		simbolos[4] = (char) (numerico / NUMEROS + VALOR_NUMERO_A_CHAR);
		numerico %= NUMEROS;
		simbolos[5] = (char) (numerico + VALOR_NUMERO_A_CHAR);

		return new Patente(new String(simbolos));
	}
}
