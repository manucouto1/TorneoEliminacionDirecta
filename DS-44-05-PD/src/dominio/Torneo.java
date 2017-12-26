/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.jugador.Jugador;
import matcher.Matcher;
import treeModel.Nodo;
import treeModel.NodoPartido;

import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 *
 * @author manuc
 */
public interface Torneo extends Iterable<Object>{
    public void inscribirJugador(Jugador jugador);
    public <T extends Jugador> void inscribirJugadores(List<T> jugadores);
    public void prepararTorneo() throws Exception;
    public <T extends Nodo> boolean iniciarTorneo() throws Exception;
    public <T extends Nodo> NodoPartido findPartido(String code) throws Exception;
    public <T extends Nodo> Map<Integer,List<T>> getTabla ();
    public <T extends Nodo> void printTabla() throws Exception;
	public void setMatcher(Matcher matcher);
	public Deque<Jugador> getJugadores();
	public Object getEstado();
    
}
