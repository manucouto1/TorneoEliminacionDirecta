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
public class Jugador {
    
    private final String name;
    private final int years;
    
    public Jugador(String name, int years) {
        this.name = "Jugador "+name;
        this.years = years;
    }

    public String getName() {
        return name;
    }
    
    public int getYears() {
        return years;
    }

}
