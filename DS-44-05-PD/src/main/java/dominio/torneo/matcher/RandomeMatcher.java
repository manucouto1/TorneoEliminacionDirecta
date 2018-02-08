/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.matcher;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import dominio.jugador.JugadorValue;

/**
 *
 * @author manuc
 */
public class RandomeMatcher implements Matcher{

    @Override
    public Deque<JugadorValue> matchPlayers(Deque<JugadorValue> jugadores) {
        Deque<JugadorValue> result = new ArrayDeque<>();
        List<JugadorValue> list = new LinkedList<>(jugadores);
        while(!list.isEmpty()){
            int aleatorio =  (int) Math.floor(Math.random()*(list.size()));
            JugadorValue jugador = list.remove(aleatorio);
            result.add(jugador);
        }
        return result;
    }

    @Override
    public Deque<JugadorValue> matchPlayers(List<JugadorValue> jugadores) {
        Deque<JugadorValue> result = new ArrayDeque<>();
        List<JugadorValue> list = new LinkedList<>(jugadores);
        while(!list.isEmpty()){
            int aleatorio =  (int) Math.floor(Math.random()*(list.size()));
            JugadorValue jugador = list.remove(aleatorio);
            result.add(jugador);
        }
        return result;
    }
    
}
