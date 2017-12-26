/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.estado;

/**
 *
 * @author manuc
 */
public  enum State {
    EN_ESPERA(1),NO_JUGADO(2),EN_JUEGO(3),FINALIZADO(4);
    
    private final int id;
    private final String name;
    
    
    State(int id) {
        String[] names = {"","en espera","no jugado","jugandose","finalizado"};
        this.id = id;
        this.name = names[id]; 
    }
    
    public int getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }    
    
}
