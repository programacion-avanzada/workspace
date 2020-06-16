package edu.unlam.progava.vehiculos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.progava.vehiculos.Automovil;
import edu.unlam.progava.vehiculos.Remise;

public class VehiculoTests {

	private Automovil auto;
	private Remise remise;

	@Before
	public void setUp() {
		auto = new Automovil("Hernán");
		remise = new Remise("Bigote");
	}

	@Test
	public void queConocenSusTipos() {
		Assert.assertEquals("automóvil", auto.getTipo());
		Assert.assertEquals("remise", remise.getTipo());
	}

	@Test
	public void queAutomovilSeDesplaza() {
		Assert.assertEquals("Soy un automóvil, me conduce Hernán. Estoy yendo de Ramos Mejía hasta UNLaM",
				auto.desplazarse("Ramos Mejía", "UNLaM"));
	}
	
	@Test
	public void queRemiseSeDesplazaVacio() {
		Assert.assertEquals("Estoy yendo a UNLaM a recoger a un pasajero",
				remise.desplazarse("Ramos Mejía", "UNLaM"));
	}
	
	@Test
	public void queRemiseSeDesplazaConDosPasajeros() {
		remise.subirPasajero("Federico");
		remise.subirPasajero("Julio");
		Assert.assertEquals("Soy un remise, me conduce Bigote. Estoy yendo de Ramos Mejía hasta UNLaM. Llevo 2 pasajeros",
				remise.desplazarse("Ramos Mejía", "UNLaM"));
	}

}
