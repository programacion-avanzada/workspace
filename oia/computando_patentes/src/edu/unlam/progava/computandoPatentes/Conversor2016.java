package edu.unlam.progava.computandoPatentes;

public class Conversor2016 extends Conversor {
	
	public Conversor2016(Patente patente) {
		super(patente);
	}
	
	@Override
	protected long getNumero() {
		char[] simbolos = patente.valor.toCharArray();
		long numerico = 0;
		numerico += (simbolos[6] + CHAR_A_VALOR_LETRA);
		numerico += (simbolos[5] + CHAR_A_VALOR_LETRA) * LETRAS;
		numerico += (simbolos[4] + CHAR_A_VALOR_NUMERO) * LETRAS2;
		numerico += (simbolos[3] + CHAR_A_VALOR_NUMERO) * LETRAS2 * NUMEROS;
		numerico += (simbolos[2] + CHAR_A_VALOR_NUMERO) * LETRAS2 * NUMEROS2;
		numerico += (simbolos[1] + CHAR_A_VALOR_LETRA) * LETRAS2 * NUMEROS3;
		numerico += (simbolos[0] + CHAR_A_VALOR_LETRA) * LETRAS3 * NUMEROS3;
		return numerico;
	}

	@Override
	protected Patente getPatenteSiguiente(long numerico) {
		char[] simbolos = new char[7];
		simbolos[0] = (char) (numerico / (LETRAS3 * NUMEROS3) + VALOR_LETRA_A_CHAR);
		numerico %= LETRAS3 * NUMEROS3;
		simbolos[1] = (char) (numerico / (LETRAS2 * NUMEROS3) + VALOR_LETRA_A_CHAR);
		numerico %= LETRAS2 * NUMEROS3;
		simbolos[2] = (char) (numerico / (LETRAS2 * NUMEROS2) + VALOR_NUMERO_A_CHAR);
		numerico %= LETRAS2 * NUMEROS2;
		simbolos[3] = (char) (numerico / (LETRAS2 * NUMEROS) + VALOR_NUMERO_A_CHAR);
		numerico %= LETRAS2 * NUMEROS;
		simbolos[4] = (char) (numerico / LETRAS2 + VALOR_NUMERO_A_CHAR);
		numerico %= LETRAS2;
		simbolos[5] = (char) (numerico / LETRAS + VALOR_LETRA_A_CHAR);
		numerico %= LETRAS;
		simbolos[6] = (char) (numerico + VALOR_LETRA_A_CHAR);

		return new Patente(new String(simbolos));
	}
}
