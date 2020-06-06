package armadomoviles;

import java.util.HashMap;
import java.util.Map;

public class Artesano {

	private int cantVarillas;
	private int pesoTotal;
	private Map<Integer, Integer> colgantes;

	public Artesano() {
		this.cantVarillas = 0;
		this.pesoTotal = 0;
		this.colgantes = new HashMap<Integer, Integer>();
	}

	public int getCantVarillas() {
		return cantVarillas;
	}

	public int getPesoTotal() {
		return pesoTotal;
	}

	public void verificarVehiculo(int clave, int pesoLeido) {

		// ¿Existe el peso en el mapa?
		if (colgantes.containsValue(pesoLeido) == true) {
			// Sí, entonces cumple la condición para formar el móvil.
			Movil m = new Movil(pesoLeido, pesoLeido);
			this.pesoTotal += m.retornarPesoTotal();
			this.cantVarillas++;

			// Eliminar el peso del colgante del mapa.
			int poseliminar = buscarClave(pesoLeido);
			colgantes.remove(poseliminar);
		} else {
			// Si no existe agregarlo al mapa.
			colgantes.put(clave, pesoLeido);
		}

	}

	private int buscarClave(int pesoLeido) {
		// Object priclave = colgantes.keySet().toArray()[0];//Obtener la primera clave
		// del HashMap.
		int posclavemapa = 1;// (int)priclave;
		int posenc = 0;

		while (posenc == 0) {
			if (colgantes.get(posclavemapa) == pesoLeido) {
				posenc = posclavemapa;
			}
			posclavemapa++;
		}

		return posenc;
	}

}
