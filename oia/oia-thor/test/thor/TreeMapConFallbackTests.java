package thor;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeMapConFallbackTests {

	private TreeMapConFallback<Integer, Integer> map;

	/*
	 * Caracteristicas:
	 * Se comporta como un Hash
	 * Al pedir una clave, si NO existe, se devuelve la inmediata anterior
	 */
	
	@Before
	public void setup() {
		this.map = new TreeMapConFallback<Integer, Integer>();
	}
	
	@Test
	public void quePuedoAgregar() {
		map.put(1, 10);
		
		Assert.assertTrue(map.containsKey(1));
		Assert.assertTrue(map.containsValue(10));
	}
	
	@Test
	public void quePuedoAccederAUnExistente() {
		map.put(1, 10);
		
		Assert.assertEquals(Integer.valueOf(10), map.get(1));
	}
	
	@Test
	public void quePuedoAccederAUnInexistente() {
		map.put(1, 10);
		map.put(3, 30);
		
		Assert.assertEquals(Integer.valueOf(10), map.get(2));		
	}
	
	@Test
	public void quePuedoAccederAUnInexistenteMenorAlMenor() {
		map.put(2, 10);
		map.put(3, 30);
		
		Assert.assertNull(map.get(1));		
	}

}
