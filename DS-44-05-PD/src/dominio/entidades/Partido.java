package dominio.entidades;

public class Partido {
	
	private int id;
	private String code;
	private int local;
	private int visitante;
	private int ganador;
	private int estado;
	
	public Partido(){}
	
	public Partido(int id, String code, int local, int visitante, int ganador, int estado) {
		this.id = id;
		this.code = code;
		this.local = local;
		this.visitante = visitante;
		this.ganador = ganador;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "Partido [id=" + id + ", code=" + code + ", local=" + local + ", visitante=" + visitante + ", ganador="
				+ ganador + ", estado=" + estado + "]";
	}
	
	
	
}
