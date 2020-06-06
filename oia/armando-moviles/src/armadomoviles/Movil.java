package armadomoviles;

public class Movil {
	private int pesoColegante1;
	private int pesoColegante2;
	private final int cantVarillas;

	public Movil(int pesocol1, int pesocol2) {
		this.pesoColegante1 = pesocol1;
		this.pesoColegante2 = pesocol2;
		this.cantVarillas = 1;
	}

	public int retornarPesoTotal() {
		return this.pesoColegante1 + this.pesoColegante2;
	}

}
