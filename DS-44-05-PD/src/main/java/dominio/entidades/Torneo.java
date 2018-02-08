package dominio.entidades;

import java.util.List;

import dominio.entidades.torneo.TorneoValue;
import new_tech_dev.development.base_entity.BaseEntity;

public class Torneo extends BaseEntity{
	
	private int id;
	private String codigo;
	private int tipo;
	private int estado;
	private List<Partido> partidosList;
	private List<Jugador> jugadorList;
	
	
	public Torneo(){
		
	}
	
	public Torneo(int id, String codigo, int tipo, int estado) {
		this.id = id;
		this.codigo = codigo;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public Torneo (Builder builder) {
		this.id = builder.id;
		this.codigo = builder.codigo;
		this.tipo = builder.tipo;
		this.estado = builder.estado;
		this.jugadorList = builder.jugadores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public List<Partido> getPartidos(){
		return this.partidosList;
	}
	
	public void setEquipos(List<Partido> partidos){
		this.partidosList = partidos;
	}
	
	public List<Jugador> getJugadorList(){
		return this.jugadorList;
	}
	
	public void setJugadorList(List<Jugador> jugadores) {
		this.jugadorList = jugadores;
	}

	
	@Override
	public String toString() {
		return "Torneo [id=" + id + ", codigo=" + codigo + ", tipo=" + tipo + ", estado=" + estado + "]";
	}


	public static class Builder {
		private int id;
		private List<Jugador> jugadores;
		private final String codigo;
		private final int tipo;
		private final int estado;
		
		public Builder(TorneoValue torneo){
			this.codigo = torneo.getCodigo();
			this.tipo = torneo.getTipo().getId();
			this.estado = torneo.getEstado().getId();
		}
		
		public Builder setId(int id){
			this.id = id;
			return this;
		}
		
		public Builder setJugadores(List<Jugador> jugadores){
			this.jugadores = jugadores;
			return this;
		}
		
		public Torneo build(){
			return new Torneo(this);
		}
	}
	
}
