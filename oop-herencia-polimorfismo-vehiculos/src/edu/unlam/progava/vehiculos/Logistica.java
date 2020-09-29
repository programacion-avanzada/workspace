package edu.unlam.progava.vehiculos;

import java.util.Iterator;
import java.util.List;

public class Logistica {

	public void organizar(List<Vehiculo> vehiculos, List<Paquete> paquetes) {
		for (Iterator<Paquete> iterator = paquetes.iterator(); iterator.hasNext();) {
			Paquete paquete = iterator.next();
			boolean haCargado = false;
			for (int i = 0; i < vehiculos.size() && !haCargado; i++) {
				Vehiculo vehiculo = vehiculos.get(i);

				if (vehiculo.puedeLlevar(paquete)) {
					vehiculo.cargar(paquete);
					iterator.remove();
					haCargado = true;
				}
			}
		}
	}
	
}
