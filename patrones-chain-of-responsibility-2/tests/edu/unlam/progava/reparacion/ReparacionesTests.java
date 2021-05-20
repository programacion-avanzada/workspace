package edu.unlam.progava.reparacion;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReparacionesTests {

	private static EstacionDeReparacion reparadores;

	@BeforeClass
	public static void setUp() {
		EstacionDeReparacion inflado = new EstacionDeInflado();
		EstacionDeReparacion frenos = new EstacionDeFrenos();
		EstacionDeReparacion engrase = new EstacionDeEngrase();
		EstacionDeReparacion ajuste = new EstacionDeAjuste();
		inflado.setSiguiente(frenos);
		frenos.setSiguiente(engrase);
		engrase.setSiguiente(ajuste);

		reparadores = inflado;
	}

	public boolean estaEnBuenEstado(Bicicleta bicicleta) {
		return bicicleta.getAireRuedaDelantera() >= 45 && bicicleta.getAireRuedaTrasera() >= 45
				&& bicicleta.frenoDelanteroFuncionando() && bicicleta.frenoTraseroFuncionando()
				&& bicicleta.getGrasaEnPlatos() >= 1 && !bicicleta.necesitaAjusteGeneral();
	}

	@Test
	public void bicicletaEnBuenEstado() {
		Bicicleta biciReferencia = new Bicicleta(45, 45, true, true, 1, false);
		Bicicleta bici = biciReferencia.clone();

		reparadores.reparar(bici);
		Assert.assertEquals(biciReferencia, bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaAire() {
		Bicicleta bici = new Bicicleta(31, 2, true, true, 1, false);
		reparadores.reparar(bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaFrenoDelantero() {
		Bicicleta bici = new Bicicleta(45, 45, false, true, 1, false);
		reparadores.reparar(bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaFrenoTrasero() {
		Bicicleta bici = new Bicicleta(45, 45, true, false, 1, false);
		reparadores.reparar(bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaAmbosFrenosNoSeArregla() {
		Bicicleta bici = new Bicicleta(45, 45, false, false, 1, false);
		reparadores.reparar(bici);
		Assert.assertFalse(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaGrasa() {
		Bicicleta bici = new Bicicleta(45, 45, true, true, 0.1, false);
		reparadores.reparar(bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaAjuste() {
		Bicicleta bici = new Bicicleta(45, 45, true, true, 1, true);
		reparadores.reparar(bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}

	@Test
	public void bicicletaNecesitaCasiTodo() {
		Bicicleta bici = new Bicicleta(0, 0, false, true, 0, true);
		reparadores.reparar(bici);
		Assert.assertTrue(estaEnBuenEstado(bici));
	}
}
