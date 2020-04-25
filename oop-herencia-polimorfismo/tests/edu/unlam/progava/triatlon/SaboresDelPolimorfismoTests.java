package edu.unlam.progava.triatlon;

import org.junit.Test;

public class SaboresDelPolimorfismoTests {

	@Test
	public void asignacionesPolimorficas() {
		Nadador nadador = new Pato();
		nadador.nadar();
		// No puedo hacer...
		// nadador.volar();
		// a pesar de que el Pato puede.
	}
	
	@Test
	public void entidadesPolimorficas() {
		hacerAlgo(new Pato());
	}

	private void hacerAlgo(Nadador nadador) {
		// el método recibe un Nadador, y lo trata como tal
		nadador.nadar();
	}
	
	@Test
	public void estructurasDeDatosPolimorficas() {
		Nadador[] nadadores = {
				new Pato(),
				new Salmon(),
				new Triatlonista()
		};
		
		// La estructura contiene Nadadores, y trata
		// a todos sus elementos por igual
		for (Nadador nadador : nadadores) {
			nadador.nadar();
		}
	}
	
}
