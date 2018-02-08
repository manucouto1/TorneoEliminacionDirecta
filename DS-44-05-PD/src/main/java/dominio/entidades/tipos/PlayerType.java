/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.entidades.tipos;

/**
 *
 * @author manuc
 */
public enum PlayerType {
    NORMAL(0),CABEZA_SERIE(1);
    
    private Integer id;
    private String name;
    
    
    PlayerType(Integer id) {
        String[] names = {"Jugador normal","Cabeza de serie"};
        this.id = id;
        this.name = names[this.id]; 
    }
    
    public Integer getId(){
    	return this.id;
    }
    
    public String getName() {
        return name;
    }    
}
