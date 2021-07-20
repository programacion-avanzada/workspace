package grafo;

public class Adyacente implements Comparable<Adyacente> {
	private int id;
	private double peso;

	public Adyacente(int id, double costo) {
		this.id = id;
		this.peso = costo;
	}

	@Override
	public String toString() {
		return "(" + id + "," + peso + ")";
	}

	@Override
	public int compareTo(Adyacente o) {
		return this.id - o.id;
		// return o.id-this.id;
	}

	public double getPeso() {
		return this.peso;
	}

	public int getId() {
		return this.id;
	}
}
