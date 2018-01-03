/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;


import java.util.Deque;
import dominio.jugador.Jugador;
import dominio.Partido;
import dominio.Ronda;
import dominio.estado.State;
import dominio.jugador.CabezaSerie;
import dominio.tipos.TournmentType;
import iterator.TreeIterator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import matcher.Matcher;
import treeModel.Abb;
import treeModel.Nodo;
import treeModel.NodoJugador;
import treeModel.NodoPartido;

/**
 *
 * @author manuc
 */
public  class TorneoED extends Abb implements Torneo{
    
      
    private Deque<Jugador> jugadores = new ArrayDeque<>();
    private State estado;
    private TournmentType type;
    private int rondaEnJuego = 0;
    private Matcher matcher;
    
    
    // Constructors
    
    public TorneoED(Deque<Jugador> jugadores, TournmentType type){
        this.jugadores = jugadores;
        this.estado = State.EN_ESPERA;
        this.type = type;
    }

    public TorneoED(TournmentType type) {
        this.estado = State.EN_ESPERA;
        this.type = type;
    }
    
    // Getters & Setters 
    
    public Deque<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Deque<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getRondaEnJuego() {
        return rondaEnJuego;
    }

    public void setRondaEnJuego(int rondaEnJuego) {
        this.rondaEnJuego = rondaEnJuego;
    }

    public State getEstado() {
        return estado;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }
    
    
    /// Logic Methods
    
    @Override
    public void inscribirJugador(Jugador jugador){
        if(this.estado.equals(State.EN_ESPERA)){
            this.jugadores.add(jugador);
        }
    }
    
    @Override
    public <T extends Jugador> void inscribirJugadores(List<T> jugadores){
        if(this.estado.equals(State.EN_ESPERA)){
            Deque<Jugador> j = new ArrayDeque<>(jugadores);
            j.addAll(this.jugadores);
            int altura = this.type.getAltura(jugadores.size());
            this.setAltura(altura);
            this.setJugadores(j);
        }
    }
    
    @Override
    public void prepararTorneo() throws Exception {
        if(this.estado.equals(State.EN_ESPERA)){
            if(esPotencia2(this.jugadores.size())&&type.equals(TournmentType.TED)){
                // TODO generar altura conTOURNMENTTYPE
                generarTabla(this.getAltura(), (this.getAltura() * 2) - 1 , this, matcher.matchPlayers(jugadores));
                this.estado = State.NO_JUGADO;
            } else {
               throw new Exception("Numero de jugadores invalido");
            }
        }
        
    }
    
    @Override
    public <T extends Nodo> boolean iniciarTorneo() throws Exception{
        if(this.estado.equals(State.NO_JUGADO)){
            try {
                Map<Integer, List<T>> tabla = getTabla();

                for(T nodo : tabla.get(1)){

                    if(nodo instanceof NodoPartido){
                        Partido partido = ((NodoPartido) nodo).getPartido();
                        NodoJugador hijo1 =  (NodoJugador) ((NodoPartido)nodo).getHojaIzquierda();
                        NodoJugador hijo2 = (NodoJugador) ((NodoPartido)nodo).getHojaDerecha();

                        if(hijo1 instanceof NodoJugador && hijo2 instanceof NodoJugador){
                            partido.asignarEquipos(((NodoJugador) hijo1).getJugador(), ((NodoJugador)hijo2).getJugador());
                        }
                    }
                }
                this.setRondaEnJuego(1);
                this.estado = State.EN_JUEGO;
                return true;
            } catch (Exception ex) {
                Logger.getLogger(TorneoED.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            throw new Exception("Error: El torneo esta "+getEstado().getName());
        }
        
        return false;
    }
    
    // Recoje todos los partidos de una ronda
    // Este metodo será util en un controlador de una app web 
    public <T extends Nodo> Ronda getRonda(int ronda) throws Exception{
      
        List<T> lista = (List<T>) getTabla().get(ronda);
        List<NodoPartido> partidos = new ArrayList<>();
        for( T element : lista ){
            if(element instanceof NodoPartido){
                partidos.add((NodoPartido) element);
            }else{
                throw new Exception("This is not a Playable Round");
            }
        }
        
        Ronda newRonda = new Ronda(ronda, partidos);
        return newRonda; 
        
    }
    
    // Abanza de ronda si la ronda esta finalizada
    // Deprecated <- Unused
    public boolean siguienteRonda(Ronda ronda) {
        
        try {
            if((this.getAltura()-1 > this.getRondaEnJuego())){
                List <NodoPartido> nodos = getRonda(this.getRondaEnJuego()+1).getPartidos();
                for(NodoPartido nodo: nodos){
                    Partido partido = nodo.getPartido();
                    Jugador jugador1 = ((NodoPartido)nodo.getHojaIzquierda()).getPartido().ganador();
                    Jugador jugador2 = ((NodoPartido)nodo.getHojaDerecha()).getPartido().ganador();
                    partido.asignarEquipos(jugador1, jugador2);
                }
                this.setRondaEnJuego(this.getRondaEnJuego()+1);
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(TorneoED.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public <T extends Nodo> NodoPartido findPartido(String code) throws Exception{
        Queue<T> colaAuxiliar = new LinkedList<>();
		colaAuxiliar.add((T) this.getRaiz()); 
		int aux = 1;
		while(!colaAuxiliar.isEmpty()) {
	            T nodo = colaAuxiliar.poll();
	            if(null != nodo){
			if(nodo instanceof NodoPartido){
	                    if(((NodoPartido) nodo).getPartido().getCode().equalsIgnoreCase(code)){
	                        return (NodoPartido) nodo;
	                    }
	                }
			colaAuxiliar.add((T) nodo.getHojaIzquierda());
			colaAuxiliar.add((T) nodo.getHojaDerecha());
	            }
		}
	        
	        throw new Exception("Partido no encontrado");
    }
    
    @Override
    public <T extends Nodo> Map<Integer,List<T>> getTabla () {
        
        Queue<T> colaAuxiliar = new LinkedList<>();
        List<T> listaAux = new ArrayList<>();
        Map<Integer,List<T>> result = new HashMap<>();
		colaAuxiliar.add((T) this.getRaiz()); 
		int aux = 1;
		while(!colaAuxiliar.isEmpty()) {
	            T nodo = (T) colaAuxiliar.poll();
	            if(null != nodo){
			if(aux != nodo.getNivel()){
	                    aux = nodo.getNivel();
	                    listaAux = new ArrayList<>();
			}
			listaAux.add(nodo);
			colaAuxiliar.add((T) nodo.getHojaIzquierda());
			colaAuxiliar.add((T) nodo.getHojaDerecha());
	            }
	            result.put(this.getAltura()-aux, listaAux);
		}
		return result;
    }
    
    @Override
    public <T extends Nodo> void printTabla() throws Exception {
        String s = "";
        if(getEstado().equals(State.EN_ESPERA)){
            throw new Exception("Error: Tablas no creadas");
        } else {
            T nodo = ((T)getRaiz());
            printAux(nodo,s);
        }
        
    }
    
     @Override
    public Iterator iterator() {
        return new TreeIterator(getRaiz());
    }
    
    
    /// Private Util Methods
	
	private <T extends Jugador> void generarTabla(int altura, int aux, Abb arbol, Deque<T> jugadores){
            if (altura == 2) {
		arbol.addNodo(new NodoPartido(aux, new Partido("#MTCH_"+(altura+aux))));
		arbol.addNodo(new NodoJugador(aux-1, jugadores.pop()));
		arbol.addNodo(new NodoJugador(aux+1, jugadores.pop()));
            } else {
		arbol.addNodo(new NodoPartido(aux, new Partido("#MTCH_"+(altura+aux))));
		generarTabla(altura-1, (int)(aux-Math.pow(2,altura-2)), arbol, jugadores);
		generarTabla(altura-1, (int)(aux+Math.pow(2,altura-2)), arbol, jugadores);
            }
	}
        
        private boolean esPotencia2(int numero){
            return Math.log(numero)/Math.log(2)%1==0;
        }
        
        private <T extends Nodo> void printAux(T nodo, String tabs) throws Exception {
        
        if(nodo instanceof NodoPartido){
            String tab = tabs;
            Partido p = ((NodoPartido) nodo).getPartido();
            System.out.print(tab+"Partido "+p.getCode()+": "+p.getState().getName());
            
            switch (p.getState().getId()){
                case 1:
                    System.out.print(". ");
                    break;
                case 2:
                case 3:
                    System.out.print(" entre "+p.getLocal().getName()+" y "+p.getVisitante().getName()+". ");
                    break;
                case 4:
                    System.out.print(", jugado entre "+p.getLocal().getName()+" y "+p.getVisitante().getName()+". Ganador "+p.ganador().getName()+". ");                    
                    break;    
            }
            System.out.print("Predecesores: {\n");
            printAux(nodo.getHojaDerecha(),tab+"\t");
            printAux(nodo.getHojaIzquierda(),tab+"\t");
            System.out.print(tab+"} (fin resumen "+p.getCode()+")\n");
        }else if(nodo instanceof NodoJugador){
            String tab = tabs;
            Jugador pl = ((NodoJugador)nodo).getJugador();
            if(pl instanceof CabezaSerie){
                System.out.print(tab+pl.getName()+", "+pl.getYears()+" años, cabeza de serie\n");
            } else {
                System.out.print(tab+pl.getName()+", "+pl.getYears()+" años\n");
            }
        }
    }
        
    //

   

   
}
    
    
    		
