package edu.unlam.progava.pelotones;
import java.util.LinkedList;
import java.util.List;

public class Peloton implements UnidadMilitar {

	private List<UnidadMilitar> unidades = new LinkedList<UnidadMilitar>();
	
	public boolean agregar(UnidadMilitar unidad) {
		return unidades.add(unidad);
	}

	@Override
	public void moverse(double dx, double dy) {
		for(UnidadMilitar unidad : unidades) {
			unidad.moverse(dx, dy);
		}
	}
	
	@Override
	public String toString() {
		return unidades.toString();
	}

	@Override
	public void atacar(UnidadMilitar objetivo) {
		for(UnidadMilitar unidad : unidades) {
			unidad.atacar(objetivo);
		}
	}

	@Override
	public void recibirAtaque() {
		for(UnidadMilitar unidad : unidades) {
			unidad.recibirAtaque();
		}
	}
}
