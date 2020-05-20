package chainOfResponsibility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChainOfResponsibilityTests {
	Operacion operacion;
	
	@Before
	public void setUp() {
		// Creo las operaciones con las cuales voy a trabajar
		operacion = new Sumar();
		Operacion resta = new Restar();
		Operacion multiplicar = new Multiplicar();
		Operacion sumaYMultiplicacion = new SumaYMultiplicacion();
		Operacion defaultOperation = new Default();

		// Creo la cadena. Suma lo llamamos como operacion, porque va a ser la primera de la cadena
		// y a la que haya que invocar cada vez que necesitemos preguntar por una operación
		operacion.establecerSiguiente(resta);
		resta.establecerSiguiente(multiplicar);
		multiplicar.establecerSiguiente(sumaYMultiplicacion);
		sumaYMultiplicacion.establecerSiguiente(defaultOperation);
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


}
