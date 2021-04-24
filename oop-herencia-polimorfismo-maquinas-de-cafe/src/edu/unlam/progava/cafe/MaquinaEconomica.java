package edu.unlam.progava.cafe;

public class MaquinaEconomica extends MaquinaDeCafe {

	private int usos = 0;
	
	@Override
	protected void descartar() {
		if (this.usos == 3) {
			super.descartar();
			this.usos = 0;
		}
	}
	
	@Override
	protected void despuesDeServir() {
		this.usos ++;
	}
}
