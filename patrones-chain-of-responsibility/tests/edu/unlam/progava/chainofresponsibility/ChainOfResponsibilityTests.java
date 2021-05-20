package edu.unlam.progava.chainofresponsibility;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChainOfResponsibilityTests {
	private static Operacion operacion;

	@BeforeClass
	public static void setUp() {
		// Creamos las operaciones
		Operacion suma = new Sumar();
		Operacion resta = new Restar();
		Operacion multiplicar = new Multiplicar();
		Operacion sumaYMultiplicacion = new SumarYMultiplicar();
		Operacion defaultOperation = new Default();

		// Enlazamos la cadena
		suma.establecerSiguiente(resta);
		resta.establecerSiguiente(multiplicar);
		multiplicar.establecerSiguiente(sumaYMultiplicacion);
		sumaYMultiplicacion.establecerSiguiente(defaultOperation);

		// Guardamos la cadena
		operacion = suma;
	}

	@Test
	public void suma() {
		Assert.assertEquals(6, operacion.calcular(new Pedido("sumar", 2, 4)));
	}

	@Test
	public void resta() {
		Assert.assertEquals(-2, operacion.calcular(new Pedido("restar", 2, 4)));
	}

	@Test
	public void multiplicacion() {
		Assert.assertEquals(8, operacion.calcular(new Pedido("multiplicar", 2, 4)));
	}

	@Test
	public void sumaYMultiplicacion() {
		Assert.assertEquals(14, operacion.calcular(new Pedido("sym", 2, 4)));
	}

	@Test(expected = RuntimeException.class)
	public void error() {
		operacion.calcular(new Pedido("nada", 2, 4));
	}

	@After
	public void after() {
		System.out.println("--------------------------------------------------");
	}

}
