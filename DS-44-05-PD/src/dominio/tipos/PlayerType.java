/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.tipos;

/**
 *
 * @author manuc
 */
public enum PlayerType {
    NORMAL(1),CABEZA_SERIE(2);
    
    private int id;
    private String name;
    
    
    PlayerType(int id) {
        String[] names = {"","Jugador normal","Cabeza de serie"};
        this.id = id;
        this.name = names[this.id]; 
    }
    
    public int getId(){
    	return this.id;
    }
    
    public String getName() {
        return name;
    }    
}
