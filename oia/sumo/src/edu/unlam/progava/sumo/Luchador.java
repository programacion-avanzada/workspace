package edu.unlam.progava.sumo;

public class Luchador {

	private int peso;
	private int altura;
	
	public Luchador(int peso, int altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}

	public boolean domina(Luchador otro) {
		boolean enPeso = this.peso > otro.peso;
		boolean igualPeso = this.peso == otro.peso;
		boolean enAltura = this.altura > otro.altura;
		boolean igualAltura = this.altura == otro.altura;
		
		return enPeso && enAltura ||
				igualPeso && enAltura ||
				igualAltura && enPeso;
	}
	
}
