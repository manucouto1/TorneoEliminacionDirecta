/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matcher;

import dominio.jugador.Jugador;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author manuc
 */
public interface Matcher {
    
    public Deque<Jugador> matchPlayers(Deque<Jugador> jugadores);
    public Deque<Jugador> matchPlayers(List<Jugador> jugadores);
}
