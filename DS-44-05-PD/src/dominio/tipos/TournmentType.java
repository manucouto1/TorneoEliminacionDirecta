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
public enum TournmentType {
    TED(0),TMF(1);
    
    private int id;
    private String name;
    
    
    TournmentType(int id) {
        String[] names = {"Torneo eliminación directa","Torneo multi fase"};
        this.id = id;
        this.name = names[this.id]; 
    }

    public String getName() {
        return name;
    }    
    
    public int getId(){
    	return this.id;
    }
    
    public Integer getAltura(int size){
        switch (id) {
            case 0:
                return (int) (Math.log(size) / Math.log(2)) + 1;
            case 1:
                return null;
            default:
                return null;
        }
    }
    
}
