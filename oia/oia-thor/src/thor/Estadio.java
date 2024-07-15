package thor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Estadio {
	List<Personaje> personajes;
	List<Objeto> objetos;

	public Estadio(List<Personaje> personajes, List<Objeto> objetos) {
		this.personajes = personajes;
		this.objetos = objetos;
	}

	// long si n * m > 2^31 -1?
	public long resolver(int distanciaMinima) {
		long cantidad = 0;
		// n2
		for (Personaje personaje : personajes) {
			for (Objeto objeto : objetos) {
				long distancia = personaje.getDistanciaPara(objeto);
				if (distancia >= distanciaMinima) {
					cantidad++;
				}
			}
		}

		return cantidad;
	}
	
	public long resolverBonito(int distanciaMinima) {
		int mayorPesoLanzable = 0;
		// n
		for (Personaje personaje : personajes) {
			mayorPesoLanzable = Math.max(personaje.getPesoMaximoParaDistancia(distanciaMinima), mayorPesoLanzable);
		}	
		
		int[] objetosHastaPeso = new int[mayorPesoLanzable + 1];

		// n
		for (Objeto objeto : objetos) {
			objetosHastaPeso[objeto.getPeso()]++;
		}
		
		// n
		for (int i = 1; i < objetosHastaPeso.length; i++) {
			objetosHastaPeso[i] += objetosHastaPeso[i - 1];
		}

		// n
		long res = 0;
		for (Personaje personaje : personajes) {
			int pesoMaximo = personaje.getPesoMaximoParaDistancia(distanciaMinima);
			res += objetosHastaPeso[pesoMaximo];
		}
		return res;
	}

	public long resolverBonitoBonito(int distanciaMinima) {
		// n log n
		Collections.sort(objetos);
		Map<Integer, Integer> objetosHastaPeso = new TreeMapConFallback<>();

		int acu = 0;
		objetosHastaPeso.put(0, 0);
		for (Objeto objeto : objetos) {
			objetosHastaPeso.put(objeto.getPeso(), ++acu);
		}
		
		long acuTotal = 0;
		// (n + 1) * log n
		for (Personaje personaje : personajes) {
			// 1
			int pesoMaximo = personaje.getPesoMaximoParaDistancia(distanciaMinima);
			// n * log n
			acuTotal += objetosHastaPeso.get(pesoMaximo);
		}

		return acuTotal;
	}
}
