/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo;

import java.util.List;

import dominio.entidades.estado.State;
import dominio.torneo.abbmodel.NodoPartido;

/**
 *
 * @author manuc
 */
public class Ronda{
    
    private final int ronda;
    private final List<NodoPartido> partidos;
    
    
    public Ronda(int ronda, List<NodoPartido> partidos) throws Exception{
        this.ronda = ronda;
        this.partidos = partidos;
        
//        boolean stable = true;
        for(NodoPartido partido : partidos){
            if(!(partido.getPartido().getState() == State.EN_ESPERA)){
//              stable = false;  
            } 
        }
        /*
        if(stable){
            this.estado = State.EN_JUEGO;
        }else{
            this.estado = State.EN_ESPERA;
        }
        */
    }
    
    public NodoPartido getNodoPartido(String name){
        int aux=0;
        PartidoValue partido;
        for(NodoPartido nodo : partidos){
            partido = nodo.getPartido();
            if(!partido.getCode().equals(name)){
                aux++;
            }else{
                break;
            }
        }
        return this.partidos.get(aux);
    }
    
    /*
    public boolean finalizar(){
        boolean finalizado = true;
        for(NodoPartido nodo: partidos){
            Partido partido = nodo.getPartido();
            if(partido.getState() != State.FINALIZADO){
                finalizado = false;
                break;
            }
        }
        if(finalizado){
            this.estado = State.FINALIZADO;
        }
        return finalizado;
    }
*/
    public int getRonda() {
        return ronda;
    }

    public List<NodoPartido> getPartidos() {
        return partidos;
    }

    
}
