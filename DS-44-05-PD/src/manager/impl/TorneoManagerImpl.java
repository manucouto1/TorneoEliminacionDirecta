/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.impl;

import dominio.jugador.JugadorValue;
import dominio.tipos.TournmentType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cache.TournmentCache;
import manager.TorneoManager;
import torneo.TorneoValue;

/**
 *
 * @author manuc
 */
public class TorneoManagerImpl implements TorneoManager{
    
    @Override
    public boolean crearTorneo(TournmentCache c, String name, TournmentType tipo) {
        return c.addTorneo(name, tipo);
    }

    @Override
    public TorneoValue seleccionarTorneo(TournmentCache c, String nombre) {
        try {
            return c.getTorneo(nombre);
        } catch (Exception ex) {
            Logger.getLogger(TorneoManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public <T extends JugadorValue>  void inscribirJugador(TorneoValue torneo, T jugador) {
        torneo.inscribirJugador(jugador);
    }

    @Override
    public <T extends JugadorValue> void inscribirJugadores(TorneoValue torneo, List<T> jugadores) {
        torneo.inscribirJugadores(jugadores);
    }

    @Override
    public void prepararTorneo(TorneoValue t) throws Exception{
        t.prepararTorneo();
    }

    @Override
    public boolean iniciarTorneo(TorneoValue t) throws Exception{
        return t.iniciarTorneo();
    }

    @Override
    public void printTable(TorneoValue t) throws Exception{
        t.printTabla();
    }

}   

