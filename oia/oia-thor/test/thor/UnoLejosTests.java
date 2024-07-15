package thor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnoLejosTests {

	private List<Personaje> personajes = new LinkedList<Personaje>();
	private List<Objeto> objetos = new LinkedList<Objeto>();

	@Before
	public void setup() {
		personajes = Arrays.asList(new Personaje[]{
			new Personaje(14, 4),
			new Personaje(10, 3),
			new Personaje(11, 5),
			new Personaje(5, 29),
			new Personaje(5000, 29000)
		});
		objetos = Arrays.asList(new Objeto[] {
				new Objeto(4),
				new Objeto(10),
				new Objeto(7)
		});
	}
	
	@Test
	public void resolver() {
		Assert.assertEquals(7, new Estadio(personajes, objetos).resolver(14));
	}
	
	@Test
	public void resolverBonito() {
		Assert.assertEquals(7, new Estadio(personajes, objetos).resolverBonito(14));
	}
	
	@Test
	public void resolverBonitoBonito() {
		Assert.assertEquals(7, new Estadio(personajes, objetos).resolverBonitoBonito(14));
	}
}
