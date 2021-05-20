package edu.unlam.progava.reparacion;

public abstract class EstacionDeReparacion {

	protected EstacionDeReparacion siguiente;

	public final void reparar(Bicicleta b) {
		boolean seguir = doReparar(b);
		if (seguir)
			seguirCadena(b);
	}

	protected abstract boolean doReparar(Bicicleta b);

	public void setSiguiente(EstacionDeReparacion siguiente) {
		this.siguiente = siguiente;
	}

	private void seguirCadena(Bicicleta b) {
		if (siguiente != null) {
			siguiente.reparar(b);
		}
	}
}
