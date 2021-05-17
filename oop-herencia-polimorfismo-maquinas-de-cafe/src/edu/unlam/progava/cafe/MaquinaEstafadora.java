package edu.unlam.progava.cafe;

public class MaquinaEstafadora extends MaquinaDeCafe {

	private boolean entregar = true;

	@Override
	protected void descartar() {
		if (entregar) {
			super.descartar();
		}
	}
	
	@Override
	protected VasoDeCafe entregar() {
		boolean deboEntregarloLleno = entregar;
		entregar = !entregar;
		return new VasoDeCafe(deboEntregarloLleno);
	}
}
