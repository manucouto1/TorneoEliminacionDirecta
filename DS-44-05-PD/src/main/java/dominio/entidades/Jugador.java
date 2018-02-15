package dominio.entidades;

import dominio.jugador.JugadorValue;
import new_tech_dev.development.base_shit.base_entity.BaseEntity;

public class Jugador extends BaseEntity{
	
	private Integer id;
	private String nombre;
	private Integer edad;
	private Integer tipo;
	
	public Jugador(){}

	public Jugador(Integer id, String nombre, Integer edad, Integer tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.tipo = tipo;
	}
	
	public Jugador(Builder jugador){
		this.id = jugador.id;
		this.nombre = jugador.nombre;
		this.edad = jugador.edad;
		this.tipo = jugador.tipo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", tipo=" + tipo + "]";
	}
	
	public static class Builder {
		private Integer id;
		private final String nombre;
		private Integer edad;
		private Integer tipo;
		
		public Builder(JugadorValue jugador){
			this.edad = jugador.getYears();
			this.nombre = jugador.getName();
			this.tipo = (jugador.getType() != null) ? jugador.getType().getId() : 0 ;
		}
		
		public Builder setId(Integer id){
			this.id = id;
			return this;
		}
		
		public Jugador build(){
			return new Jugador(this);
			
		}
	}
	
	
	
	
}
