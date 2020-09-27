package ar.edu.unlam.formandoequipos;

public class Equipo {
	private int cantColab;
	private String respuestas;
	private int cantRespIguales;
		
	public int getCantColab() {
		return cantColab;
	}

	public void setCantColab(int cantColab) {
		this.cantColab = cantColab;
	}

	public String getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}

	public int getCantRespIguales() {
		return cantRespIguales;
	}

	public void setCantRespIguales(int cantRespIguales) {
		this.cantRespIguales = cantRespIguales;
	}

	public int calcularAfinidad() {
		return this.cantColab * (this.cantRespIguales * this.cantRespIguales);
	}
	
	public void aumentarCantColab() {
		this.cantColab++;
	}
}
