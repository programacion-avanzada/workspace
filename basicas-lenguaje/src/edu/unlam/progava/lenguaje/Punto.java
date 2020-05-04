package edu.unlam.progava.lenguaje;

public class Punto implements Comparable<Punto> {

	private double x, y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public double getModulo() {
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

	@Override
	public int compareTo(Punto otro) {
		Double miModulo = getModulo();
		Double otroModulo = otro.getModulo();

//		if (miModulo == otroModulo) return 0;
//		if (miModulo < otroModulo) return -1;
//		return 1;

//		return (int)(miModulo - otroModulo);

		return miModulo.compareTo(otroModulo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public Punto mover(double dx, double dy) {
		return new Punto(this.x + dx, this.y + dy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Punto other = (Punto) obj;

		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	// http://commons.apache.org/proper/commons-lang/download_lang.cgi

//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}

	@Override
	public Punto clone() throws CloneNotSupportedException {
		return new Punto(this.x, this.y);
	}	
}
