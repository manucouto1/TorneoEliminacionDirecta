/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.abbmodel;


import dominio.jugador.JugadorValue;

/**
 *
 * @author manuc
 */
public class NodoJugador extends Nodo{
    
    private JugadorValue jugador;
    
    public NodoJugador(int peso, JugadorValue jugador) {
        super(peso);
        this.jugador = jugador;
    }

    public JugadorValue getJugador() {
        return jugador;
    }

    public void setJugador(JugadorValue jugador) {
        this.jugador = jugador;
    }
    
    @Override
    public String toString() {
        return "NodoJugador{" + "jugador=" + jugador + ", nivel=" + super.getNivel() +", peso = "+super.getPeso() + '}';
    }
    
    
    
}
