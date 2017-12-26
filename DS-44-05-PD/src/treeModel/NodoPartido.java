/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeModel;


import dominio.Partido;

/**
 *
 * @author manuc
 */
public class NodoPartido extends Nodo {
    
    private Partido partido;
    
    public NodoPartido(int peso, Partido partido) {
        super(peso);
        this.partido = partido; 
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    @Override
    public String toString() {
        return "NodoPartido{" + "partido=" + partido + ", nivel=" + super.getNivel() +", peso = "+super.getPeso() + '}';
    }
    
    
    
}
