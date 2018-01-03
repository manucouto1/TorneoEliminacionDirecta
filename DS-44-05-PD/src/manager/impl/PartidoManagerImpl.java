/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.impl;

import dominio.Partido;
import dominio.estado.State;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.PartidoManager;
import torneo.TorneoValue;
import treeModel.NodoJugador;
import treeModel.NodoPartido;

/**
 *
 * @author manuc
 */
public class PartidoManagerImpl implements PartidoManager{
    
    @Override
    public Partido findPartido(TorneoValue torneo, String code) throws Exception{
    	Partido partido = torneo.findPartido(code).getPartido();
    	if(partido == null) {
    		
    	}
        return torneo.findPartido(code).getPartido();
    }

    @Override
    public boolean preparePartido(String partidoCode, TorneoValue torneo) throws Exception{
        
        NodoPartido partido = torneo.findPartido(partidoCode);
        
        if((partido.getHojaIzquierda() instanceof NodoPartido) && (partido.getHojaDerecha() instanceof NodoPartido)){
            if (((NodoPartido) partido.getHojaIzquierda()).getPartido().getState().equals(State.FINALIZADO) 
                && ((NodoPartido) partido.getHojaDerecha()).getPartido().getState().equals(State.FINALIZADO)) {
                
                partido.getPartido().asignarEquipos(((NodoPartido)partido.getHojaIzquierda()).getPartido().ganador(), 
                        ((NodoPartido)partido.getHojaDerecha()).getPartido().ganador());
                return true;
                
            } else {
                Logger.getLogger(PartidoManagerImpl.class.getName())
                        .log(Level.SEVERE, null, " @@## Alguno de los partidos previos aun no ha terminado");
                Logger.getLogger(PartidoManagerImpl.class.getName())
                        .log(Level.SEVERE, null, " * " + ((NodoPartido) partido.getHojaIzquierda()).getPartido().getCode() + " - " 
                                                       + ((NodoPartido) partido.getHojaIzquierda()).getPartido().getState());
                Logger.getLogger(PartidoManagerImpl.class.getName())
                        .log(Level.SEVERE, null, " * " + ((NodoPartido) partido.getHojaDerecha()).getPartido().getCode() + " - " 
                                                       + ((NodoPartido) partido.getHojaDerecha()).getPartido().getState());
            }
        } else if((partido.getHojaIzquierda() instanceof NodoJugador) && (partido.getHojaDerecha() instanceof NodoJugador)) {
            partido.getPartido().asignarEquipos(((NodoJugador) partido.getHojaIzquierda()).getJugador(), 
                    ((NodoJugador) partido.getHojaDerecha()).getJugador());
            return true;
        }

        return false; 
    }
    
    @Override
    public void iniciarPartido(Partido partido) throws Exception{
        partido.empezarPartido();
    }

    @Override
    public void setMarcador(Partido partido, int local, int visitante) throws Exception{
       
        if(partido.getState().equals(State.EN_JUEGO)){
            partido.getMarcador().put(partido.getLocal(), local);
            partido.getMarcador().put(partido.getVisitante(), visitante);
        }else{
            throw new Exception("Error: no se pueden poner resultados el Partido esta "+partido.getState());
        }
    }

    @Override
    public void finalizarPartido(Partido partido) throws Exception {
        partido.finalizarPartido();
    }

    
    
}

