package edu.unlam.progava.reparacion;

public class EstacionDeFrenos extends EstacionDeReparacion {

	@Override
	public boolean doReparar(Bicicleta b) {

		if (!b.frenoDelanteroFuncionando() && !b.frenoTraseroFuncionando()) {
			return false;
		}

		if (!b.frenoDelanteroFuncionando()) {
			b.arreglarFrenoDelantero();
		}

		if (!b.frenoTraseroFuncionando()) {
			b.arreglarFrenoTrasero();
		}
		return true;
	}
}
