/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;

import dominio.estado.State;
import dominio.jugador.JugadorValue;
import dominio.tipos.TournmentType;
import torneo.matcher.Matcher;
import treeModel.Nodo;
import treeModel.NodoPartido;

import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 *
 * @author manuc
 */
public interface TorneoValue extends Iterable<Object>{
	
	public int getId();
	public void setId(int id);
	public String getCodigo();
	public void setCodigo(String codigo);
	public TournmentType getTipo();
	public void setTipo(int tipo);
	public void setTipo(TournmentType tipo);
	public void setEstado(int estado);
	public void setJugadores(List<JugadorValue> jugadores);
	
    public void inscribirJugador(JugadorValue jugador);
    public <T extends JugadorValue> void inscribirJugadores(List<T> jugadores);
    public void prepararTorneo() throws Exception;
    public <T extends Nodo> boolean iniciarTorneo() throws Exception;
    public <T extends Nodo> NodoPartido findPartido(String code) throws Exception;
    public <T extends Nodo> Map<Integer,List<T>> getTabla ();
    public <T extends Nodo> void printTabla() throws Exception;
	public void setMatcher(Matcher matcher);
	public Deque<JugadorValue> getJugadores();
	public State getEstado();
    
}
