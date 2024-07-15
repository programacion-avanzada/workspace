package thor;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FatigaTests {
	
	final int MAX = 1000000000;

	private List<Personaje> personajes = new LinkedList<Personaje>();
	private List<Objeto> objetos = new LinkedList<Objeto>();

	@Before
	public void setup() {
		for(int i = 1; i <= 1000000; i++) {
			personajes.add(new Personaje(1000001 - i, i));

		}
		for(int i = 1; i <= 1000000; i++) {
			objetos.add(new Objeto(i));
		}
	}
	
	@Test(timeout=5000)
	public void resolver() {
		Assert.assertEquals(999986999862L, new Estadio(personajes, objetos).resolver(14));
	}
	
	@Test(timeout=5000)
	public void resolverBonito() {
		Assert.assertEquals(999986999862L, new Estadio(personajes, objetos).resolverBonito(14));
	}	
	@Test(timeout=5000)
	public void resolverBonitoBonito() {
		Assert.assertEquals(999986999862L, new Estadio(personajes, objetos).resolverBonitoBonito(14));
	}
}
