package edu.unlam.progava.reparacion;

public class EstacionDeEngrase extends EstacionDeReparacion {

	@Override
	public boolean doReparar(Bicicleta b) {
		while (b.getGrasaEnPlatos() < 1) {
			b.agregarGrasaEnPlatos(0.21);
		}

		return true;
	}
}
