/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeModel;


import dominio.jugador.Jugador;

/**
 *
 * @author manuc
 */
public class NodoJugador extends Nodo{
    
    private Jugador jugador;
    
    public NodoJugador(int peso, Jugador jugador) {
        super(peso);
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    @Override
    public String toString() {
        return "NodoJugador{" + "jugador=" + jugador + ", nivel=" + super.getNivel() +", peso = "+super.getPeso() + '}';
    }
    
    
    
}
