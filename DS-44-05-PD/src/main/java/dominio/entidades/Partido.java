package dominio.entidades;

public class Partido {
	
	private String id;
	private int local;
	private int visitante;
	private int ganador;
	private int estado;
	
	public Partido(){}
	
	public Partido(String id, int local, int visitante, int ganador, int estado) {
		this.id = id;
		this.local = local;
		this.visitante = visitante;
		this.ganador = ganador;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	public int getVisitante() {
		return visitante;
	}

	public void setVisitante(int visitante) {
		this.visitante = visitante;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", local=" + local + ", visitante=" + visitante + ", ganador="
				+ ganador + ", estado=" + estado + "]";
	}
	
	
	
}
