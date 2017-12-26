/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.impl;

import contenedor.Container;
import dominio.Torneo;
import dominio.jugador.Jugador;
import dominio.tipos.TournmentType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.TorneoManager;

/**
 *
 * @author manuc
 */
public class TorneoManagerImpl implements TorneoManager{
    
    @Override
    public boolean crearTorneo(Container c, String name, TournmentType tipo) {
        return c.addTorneo(name, tipo);
    }

    @Override
    public Torneo seleccionarTorneo(Container c, String nombre) {
        try {
            return c.getTorneo(nombre);
        } catch (Exception ex) {
            Logger.getLogger(TorneoManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public <T extends Jugador>  void inscribirJugador(Torneo torneo, T jugador) {
        torneo.inscribirJugador(jugador);
    }

    @Override
    public <T extends Jugador> void inscribirJugadores(Torneo torneo, List<T> jugadores) {
        torneo.inscribirJugadores(jugadores);
    }

    @Override
    public void prepararTorneo(Torneo t) throws Exception{
        t.prepararTorneo();
    }

    @Override
    public boolean iniciarTorneo(Torneo t) throws Exception{
        return t.iniciarTorneo();
    }

    @Override
    public void printTable(Torneo t) throws Exception{
        t.printTabla();
    }

}   

