package edu.unlam.progava.vehiculos;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LogisticaTests {

	@Test
	public void testUnVehiculoNoLleva() {
		List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		Vehiculo bicicleta = new Bicicleta("Moron");
		vehiculos.add(bicicleta);
		

		List<Paquete> paquetes = new LinkedList<Paquete>();
		paquetes.add(new Paquete("Castelar", 15));

		new Logistica().organizar(vehiculos, paquetes);
		
		assertEquals(0, bicicleta.getCarga());
		assertEquals(0, bicicleta.getPaquetes());
	}
	
	@Test
	public void testUnVehiculoLlevaTodo() {
		List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		Vehiculo bicicleta = new Bicicleta("Moron");
		vehiculos.add(bicicleta);
		

		List<Paquete> paquetes = new LinkedList<Paquete>();
		paquetes.add(new Paquete("Moron", 15));

		new Logistica().organizar(vehiculos, paquetes);
		
		assertEquals(15, bicicleta.getCarga());
		assertEquals(1, bicicleta.getPaquetes());
	}
	
	@Test
	public void testDosVehiculosLlevanTodo() {
		List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		Vehiculo bicicleta = new Bicicleta("Moron");
		vehiculos.add(bicicleta);
		Camioneta camioneta = new Camioneta();
		camioneta.agregarZona("Castelar");
		camioneta.agregarZona("Haedo");
		vehiculos.add(camioneta);

		List<Paquete> paquetes = new LinkedList<Paquete>();
		paquetes.add(new Paquete("Haedo", 150));
		paquetes.add(new Paquete("Castelar", 50));
		paquetes.add(new Paquete("Moron", 15));

		new Logistica().organizar(vehiculos, paquetes);

		assertEquals(15, bicicleta.getCarga());
		assertEquals(1, bicicleta.getPaquetes());
		
		assertEquals(200, camioneta.getCarga());
		assertEquals(2, camioneta.getPaquetes());
	}
}
