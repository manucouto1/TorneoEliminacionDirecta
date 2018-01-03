/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.jugador;



/**
 *
 * @author manuc
 */
public final class CabezaSerie extends JugadorValue{
    
    private CabezaSerie(Builder builder) {
        super("CabezaSerie "+builder.name, builder.years);
    }
    
    public static class Builder {
        private final String name;
        private final int years;
        
        public Builder(String name, int years){
            this.name = name;
            this.years = years;
        }
        
        public CabezaSerie build(){
            return new CabezaSerie(this);
        }
    }
}
