package thor;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GrandesTests {

	private List<Personaje> personajes = new LinkedList<Personaje>();
	private List<Objeto> objetos = new LinkedList<Objeto>();

	@Before
	public void setup() {
		for(int i = 0; i < 10000; i++) {
			personajes.add(new Personaje(10000 - i, i));

		}
		for(int i = 0; i < 4500; i++) {
			objetos.add(new Objeto((int) (5000 + i * (Math.pow(-1, i)))));
		}
	}
	
	@Test
	public void resolver() {
		Assert.assertEquals(44936946, new Estadio(personajes, objetos).resolver(14));
	}
	
	@Test
	public void resolverBonito() {
		Assert.assertEquals(44936946, new Estadio(personajes, objetos).resolverBonito(14));
	}
	
	@Test
	public void resolverBonitoBonito() {
		Assert.assertEquals(44936946, new Estadio(personajes, objetos).resolverBonitoBonito(14));
	}
}
