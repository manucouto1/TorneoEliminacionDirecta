/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.util.HashMap;
import java.util.Map;
import dominio.jugador.Jugador;
import dominio.estado.State;
import java.util.Objects;

/**
 *
 * @author manuc
 */
public final class Partido{

    private Jugador local;
    private Jugador visitante;
    private State state;
    private Map<Jugador,Integer> marcador;
    private Jugador ganador = null;
    private String code;
    
    public Partido (String code) {
        this.state = State.EN_ESPERA;
        this.code = code;
    }
    
    public State asignarEquipos(Jugador local, Jugador visitante) throws Exception{
        this.local = local;
        this.visitante = visitante;
        if(this.visitante!= null && this.local != null){
            this.marcador = new HashMap<>();
            marcador.put(local, 0);
            marcador.put(visitante, 0);
            this.state = State.NO_JUGADO;
        }else{
            throw new Exception(" - ERROR : Datos inválidos");
        }    
        return this.state;
    }
    
    public State empezarPartido() throws Exception {
        if(state==State.NO_JUGADO){
            this.state = State.EN_JUEGO;
        }else{
            throw new Exception("ERROR: el partido esta "+state.getName());
        }
        return state;
    }
    
    public State finalizarPartido() throws Exception {
        if(Objects.equals(marcador.get(visitante), marcador.get(local))){
            throw new Exception("Alert: el partido esta "+state.getName()+" tiempo añadido");
        }else{
            if(state == State.EN_JUEGO){
                this.state = State.FINALIZADO;
                if (marcador.get(local) > marcador.get(visitante)) {
                    this.ganador = local;
                } else if (marcador.get(local) < marcador.get(visitante)) {
                    this.ganador = visitante;
                } 
                System.out.println("resultado :"+this.ganador);
                
            }else{
                throw new Exception("ERROR: el partido esta "+state.getName());
            }
        }
        return state;
    }
    
    public Jugador ganador() throws Exception {
       
        if(state == State.FINALIZADO){
            return this.ganador;
        }else{
            throw new Exception("ERROR: el partido esta "+state.getName());
        }      
    }
   
    // Marca un gol para el jugador o equipo seleccionado
    // Method DEPRECATED
    public Map<Jugador,Integer> marcar (Jugador jugador) throws Exception{
        if(jugador == local || jugador == visitante) {
            if(state == State.EN_JUEGO){
                Integer aux = marcador.get(jugador);
                marcador.put(jugador, aux+1);
            } else {
                throw new Exception("ERROR: el partido esta "+state.getName());
            }
        }else {
            throw new Exception("ERROR: El equipo es erroneo");
        }
        return marcador;
    }
    
//  Getters y Setters

    public Jugador getLocal() {
        return local;
    }

    public void setLocal(Jugador local) {
        this.local = local;
    }

    public Jugador getVisitante() {
        return visitante;
    }

    public void setVisitante(Jugador visitante) {
        this.visitante = visitante;
    }
    
    public State getState(){
        return this.state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<Jugador, Integer> getMarcador() {
        return marcador;
    }

    public void setMarcador(Map<Jugador, Integer> marcador) {
        this.marcador = marcador;
    }
    
}
