package grafo;

public class Nodo implements Comparable<Nodo> {
	private int id;
	private double peso;

	public Nodo(int id, double costo) {
		this.id = id;
		this.peso = costo;
	}

	@Override
	public String toString() {
		return "(" + id + "," + peso + ")";
	}

	@Override
	public int compareTo(Nodo o) {
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
