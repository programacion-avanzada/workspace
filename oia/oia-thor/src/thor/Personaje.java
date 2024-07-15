package thor;

public class Personaje {
	private long alturaFuerza;

	public Personaje(int altura, int fuerza) {
		alturaFuerza = Math.min(1_000_000_000, (long) altura * fuerza);
	}

	public long getDistanciaPara(Objeto objeto) {
		return alturaFuerza / objeto.getPeso();
	}
	
	public int getPesoMaximoParaDistancia(int distanciaMinima) {
		return (int) (alturaFuerza / distanciaMinima);
	}
}
