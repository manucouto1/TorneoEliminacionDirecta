package dominio.entidades;

import new_tech_dev.development.base_entity.BaseEntity;
import torneo.TorneoValue;

public class Torneo extends BaseEntity{
	
	private int id;
	private String codigo;
	private int tipo;
	private int estado;
	
	
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

	
	@Override
	public String toString() {
		return "Torneo [id=" + id + ", codigo=" + codigo + ", tipo=" + tipo + ", estado=" + estado + "]";
	}


	public static class Builder {
		private int id;
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
		
		public Torneo build(){
			return new Torneo(this);
		}
	}
	
}
