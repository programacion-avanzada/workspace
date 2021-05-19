package edu.unlam.progava.olivares.estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.unlam.progava.olivares.Lanzamiento;

public class NlogN extends Estrategia {

	/**
	 * @CC O(n * log(n) + 2n)
	 * @SpaceComplexity Clone, o usar como metodo mutable
	 */
	@Override
	public int obtenerMejorR2(final List<Lanzamiento> _lanzamientos) {
		// Clonamos O(n)
		List<Lanzamiento> lanzamientos = new ArrayList<Lanzamiento>(_lanzamientos);

		// Ordenamos O(n * log(n))
		Collections.sort(lanzamientos, new Comparator<Lanzamiento>() {
			@Override
			public int compare(Lanzamiento l1, Lanzamiento l2) {
				return Integer.compare(l1.getDistanciaCuadrado(), l2.getDistanciaCuadrado());
			}
		});

		// Recorremos los lanzamientos y obtenemos el más favorable O(n)
		int mejorR2 = 0;
		int mejorAcu = 0;

		int acu = 0;
		int R2 = lanzamientos.get(0).getDistanciaCuadrado();

		Lanzamiento lanzamiento;
		for (int i = 0; i < lanzamientos.size(); i++) {
			lanzamiento = lanzamientos.get(i);

			if (lanzamiento.getDistanciaCuadrado() != R2) {
				if (acu > mejorAcu) {
					mejorAcu = acu;
					mejorR2 = R2;
				}
				R2 = lanzamiento.getDistanciaCuadrado();
			}
			acu += lanzamiento.esFavorable() ? 1 : -1;
		}
		if (acu > mejorAcu) {
			mejorAcu = acu;
			mejorR2 = R2;
		}

		return mejorR2;
	}
}
