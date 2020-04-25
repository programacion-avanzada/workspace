package edu.unlam.progava.triatlon;

import org.junit.Test;

public class PatoTests {

	@Test
	public void quePatoPuedeRealizarLasAcciones() {
		Pato miPato = new Pato();
		miPato.correr();
		miPato.nadar();
		miPato.volar();
	}
	
	@Test
	public void quePuedeCumplirTodasLasInterfaces() {
		Pato miPato = new Pato();
		Nadador nadador = miPato;
		nadador.nadar();
		
		Volador volador = miPato;
		volador.volar();
		
		Corredor corredor = miPato;
		corredor.correr();
	}
}
