package edu.unlam.progava.reparacion;

public class EstacionDeInflado extends EstacionDeReparacion {

	@Override
	public boolean doReparar(Bicicleta b) {
		while (b.getAireRuedaDelantera() < 45) {
			b.agregarAireEnRuedaDelantera(3);
		}
		while (b.getAireRuedaTrasera() < 45) {
			b.agregarAireEnRuedaTrasera(3);
		}
		return true;
	}
}
