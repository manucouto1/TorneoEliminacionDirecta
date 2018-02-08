/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.abbmodel;


import dominio.torneo.PartidoValue;

/**
 *
 * @author manuc
 */
public class NodoPartido extends Nodo {
    
    private PartidoValue partido;
    
    public NodoPartido(int peso, PartidoValue partido) {
        super(peso);
        this.partido = partido; 
    }

    public PartidoValue getPartido() {
        return partido;
    }

    public void setPartido(PartidoValue partido) {
        this.partido = partido;
    }
    
    @Override
    public String toString() {
        return "NodoPartido{" + "partido=" + partido + ", nivel=" + super.getNivel() +", peso = "+super.getPeso() + '}';
    }
    
    
    
}
