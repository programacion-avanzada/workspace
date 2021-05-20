package edu.unlam.progava.reparacion;

public class Bicicleta {

	private int aireRuedaTrasera;
	private int aireRuedaDelantera;

	private boolean frenoDelanteroFuncionando;
	private boolean frenoTraseroFuncionando;

	private double grasaEnPlatos;

	private boolean necesitaAjusteGeneral;

	public Bicicleta(int aireRuedaDelantera, int aireRuedaTrasera, boolean frenoDelanteroFuncionando,
			boolean frenoTraseroFuncionando, double grasaEnPlatos, boolean necesitaAjusteGeneral) {
		this.aireRuedaTrasera = aireRuedaTrasera;
		this.aireRuedaDelantera = aireRuedaDelantera;
		this.frenoDelanteroFuncionando = frenoDelanteroFuncionando;
		this.frenoTraseroFuncionando = frenoTraseroFuncionando;
		this.grasaEnPlatos = grasaEnPlatos;
		this.necesitaAjusteGeneral = necesitaAjusteGeneral;
	}

	protected Bicicleta clone() {
		return new Bicicleta(this.aireRuedaDelantera, this.aireRuedaTrasera, this.frenoDelanteroFuncionando,
				this.frenoTraseroFuncionando, this.grasaEnPlatos, this.necesitaAjusteGeneral);
	}

	public boolean frenoDelanteroFuncionando() {
		return frenoDelanteroFuncionando;
	}

	public void arreglarFrenoDelantero() {
		this.frenoDelanteroFuncionando = true;
	}

	public boolean frenoTraseroFuncionando() {
		return frenoTraseroFuncionando;
	}

	public void arreglarFrenoTrasero() {
		this.frenoTraseroFuncionando = true;
	}

	public double getGrasaEnPlatos() {
		return grasaEnPlatos;
	}

	public void agregarGrasaEnPlatos(double grasaEnPlatos) {
		this.grasaEnPlatos += grasaEnPlatos;
	}

	public boolean necesitaAjusteGeneral() {
		return necesitaAjusteGeneral;
	}

	public void ajustar() {
		this.necesitaAjusteGeneral = false;
	}

	public int getAireRuedaTrasera() {
		return aireRuedaTrasera;
	}

	public int getAireRuedaDelantera() {
		return aireRuedaDelantera;
	}

	public void agregarAireEnRuedaTrasera(int incremento) {
		this.aireRuedaTrasera += incremento;
	}

	public void agregarAireEnRuedaDelantera(int incremento) {
		this.aireRuedaDelantera += incremento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aireRuedaDelantera;
		result = prime * result + aireRuedaTrasera;
		result = prime * result + (frenoDelanteroFuncionando ? 1231 : 1237);
		result = prime * result + (frenoTraseroFuncionando ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(grasaEnPlatos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (necesitaAjusteGeneral ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicicleta other = (Bicicleta) obj;
		if (aireRuedaDelantera != other.aireRuedaDelantera)
			return false;
		if (aireRuedaTrasera != other.aireRuedaTrasera)
			return false;
		if (frenoDelanteroFuncionando != other.frenoDelanteroFuncionando)
			return false;
		if (frenoTraseroFuncionando != other.frenoTraseroFuncionando)
			return false;
		if (Double.doubleToLongBits(grasaEnPlatos) != Double.doubleToLongBits(other.grasaEnPlatos))
			return false;
		if (necesitaAjusteGeneral != other.necesitaAjusteGeneral)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bicicleta [aireRuedaTrasera=" + aireRuedaTrasera + ", aireRuedaDelantera=" + aireRuedaDelantera
				+ ", frenoDelanteroFuncionando=" + frenoDelanteroFuncionando + ", frenoTraseroFuncionando="
				+ frenoTraseroFuncionando + ", grasaEnPlatos=" + grasaEnPlatos + ", necesitaAjusteGeneral="
				+ necesitaAjusteGeneral + "]";
	}
}
