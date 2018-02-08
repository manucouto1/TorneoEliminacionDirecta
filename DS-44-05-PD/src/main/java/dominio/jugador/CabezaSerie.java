/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.jugador;

import dominio.entidades.tipos.PlayerType;

/**
 *
 * @author manuc
 */
public final class CabezaSerie extends JugadorValue{
    
    private CabezaSerie(Builder builder) {
        super("CabezaSerie "+builder.name, builder.years, builder.tipo);
    }
    
    public static class Builder {
        private final String name;
        private final int years;
        private final PlayerType tipo;
        
        public Builder(String name, int years){
            this.name = name;
            this.years = years;
            this.tipo = PlayerType.CABEZA_SERIE;
        }
        
        public CabezaSerie build(){
            return new CabezaSerie(this);
        }
    }
}
