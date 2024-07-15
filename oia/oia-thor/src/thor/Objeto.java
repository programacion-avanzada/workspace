package thor;

public class Objeto implements Comparable<Objeto> {
	private int peso;

	public Objeto(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return this.peso;
	}

	@Override
	public int compareTo(Objeto o) {
		return this.peso - o.peso;
	}
}
