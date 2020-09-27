package ar.edu.unlam.tarzan;

public class Arbol {

	private int x;
	private int y;	

	public Arbol(int x, int y) {
		this.x = x;
		this.y = y;
	}		

	public int calcularDistanciaEntreArboles(Arbol arb) {
		return (int) Math.sqrt(Math.pow((arb.x-this.x), 2) + Math.pow((arb.y-this.y), 2));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
