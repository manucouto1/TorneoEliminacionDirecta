/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matcher;

import dominio.jugador.Jugador;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author manuc
 */
public class RandomeMatcher implements Matcher{

    @Override
    public Deque<Jugador> matchPlayers(Deque<Jugador> jugadores) {
        Deque<Jugador> result = new ArrayDeque<>();
        List<Jugador> list = new LinkedList<>(jugadores);
        while(!list.isEmpty()){
            int aleatorio =  (int) Math.floor(Math.random()*(list.size()));
            Jugador jugador = list.remove(aleatorio);
            result.add(jugador);
        }
        return result;
    }

    @Override
    public Deque<Jugador> matchPlayers(List<Jugador> jugadores) {
        Deque<Jugador> result = new ArrayDeque<>();
        List<Jugador> list = new LinkedList<>(jugadores);
        while(!list.isEmpty()){
            int aleatorio =  (int) Math.floor(Math.random()*(list.size()));
            Jugador jugador = list.remove(aleatorio);
            result.add(jugador);
        }
        return result;
    }
    
}
