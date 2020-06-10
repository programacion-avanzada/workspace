package armadomoviles;

public class Movil {
	private int peso1;
	private int peso2;

	public Movil(int peso1, int peso2) {
		this.peso1 = peso1;
		this.peso2 = peso2;
	}

	public int getPesoTotal() {
		return this.peso1 + this.peso2;
	}
}
