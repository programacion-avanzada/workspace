package edu.unlam.progava.cafe;

public abstract class MaquinaDeCafe {

	protected static final int GRAMOS_POR_CAFE = 12;
	protected int gramos = 1000;

	protected boolean puedeServir() {
		return this.gramos >= GRAMOS_POR_CAFE;
	}

	protected void descartar() {
		this.gramos -= GRAMOS_POR_CAFE;
	}

	protected void despuesDeServir() {
		// por defecto, no hacer nada
	}

	public final VasoDeCafe servir() {
		if (puedeServir()) {
			despuesDeServir();
			descartar();
			return entregar();
		}
		return null; // preferentemente utilizar NullObject, en lugar de null
	}

	protected VasoDeCafe entregar() {
		return new VasoDeCafe(true);
	}
}
