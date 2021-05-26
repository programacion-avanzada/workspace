package edu.unlam.progava.reparacion;

public class EstacionDeAjuste extends EstacionDeReparacion {

	@Override
	public boolean doReparar(Bicicleta b) {
		if (b.necesitaAjusteGeneral()) {
			b.ajustar();
		}
		return true;
	}
}
