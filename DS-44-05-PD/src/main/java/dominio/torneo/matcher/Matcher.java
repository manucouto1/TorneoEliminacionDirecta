/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.matcher;

import java.util.Deque;
import java.util.List;

import dominio.jugador.JugadorValue;

/**
 *
 * @author manuc
 */
public interface Matcher {
    
    public Deque<JugadorValue> matchPlayers(Deque<JugadorValue> jugadores);
    public Deque<JugadorValue> matchPlayers(List<JugadorValue> jugadores);
}
