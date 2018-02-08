/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.jugador;

import dominio.entidades.Jugador;
import dominio.entidades.tipos.PlayerType;

/**
 *
 * @author manuc
 */
public class JugadorValue {
    
	private Integer id;
    private final String name;
    private final Integer years;
    private PlayerType tipo = PlayerType.NORMAL;
    
    public JugadorValue(String name, int years, PlayerType tipo) {
        this.name = "Jugador "+name;
        this.years = years;
        this.tipo = tipo;
    }
    public JugadorValue(String name, int years) {
        this.name = "Jugador "+name;
        this.years = years;
    }
    
    public JugadorValue(Builder builder){
    	this.id = builder.id;
    	this.name = builder.nombre;
    	this.years = builder.edad;
    	this.tipo = PlayerType.values()[builder.tipo];
    }

    public String getName() {
        return name;
    }
    
    public int getYears() {
        return years;
    }
    
    public PlayerType getType() {
    	return tipo;
    }
    
    public static class Builder{
		
		private int id;
		private final String nombre;
		private final int edad;
		private final int tipo;
		
		public Builder(Jugador jugador){
			this.edad = jugador.getEdad();
			this.nombre = jugador.getNombre();
			this.tipo = jugador.getTipo();
		}
		
		public Builder setId(int id){
			this.id = id;
			return this;
		}
		
		public JugadorValue build(){
			return new JugadorValue(this);
			
		}
	}

	@Override
	public String toString() {
		return "JugadorValue [id=" + id + ", name=" + name + ", years=" + years + ", tipo=" + tipo + "]";
	}
    
}
