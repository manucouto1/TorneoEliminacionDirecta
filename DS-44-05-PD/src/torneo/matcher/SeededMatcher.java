/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo.matcher;

import dominio.jugador.CabezaSerie;
import dominio.jugador.JugadorValue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author manuc
 */
public class SeededMatcher implements Matcher{

    @Override
    public Deque<JugadorValue> matchPlayers(Deque<JugadorValue> jugadores) {
        Deque<JugadorValue> result = new ArrayDeque<>();
        List<JugadorValue> list = new LinkedList<>();
        List<JugadorValue> listC = new LinkedList<>();
        jugadores.forEach((jugador) -> {
//            System.out.println("@@## JugadorName > "+jugador.getName());
            if(jugador instanceof CabezaSerie){
                listC.add(jugador);
            }else{
                list.add(jugador);
            }
        });
        int counter = 0;
        int aux = Math.round(list.size()/listC.size());
//        System.out.println("@@## list > "+list.size()+" listC > "+listC.size());
                
                
        while(!listC.isEmpty() || !list.isEmpty()){
//            System.out.println(" @@## aux >> "+aux+" > % > "+counter%aux);
            int aleatorio1 =  (int) Math.floor(Math.random()*(list.size()));
            int aleatorio =  (int) Math.floor(Math.random()*(listC.size()));
            JugadorValue jugador = null ;
            if(counter%aux==0&&!listC.isEmpty()){
                jugador = listC.remove(aleatorio);
            }else{
                jugador = list.remove(aleatorio1);
            }
            if(jugador!=null){
                result.add(jugador);
            }
            counter++;
        }
       
        return result;
    }

    @Override
    public Deque<JugadorValue> matchPlayers(List<JugadorValue> jugadores) {
        Deque<JugadorValue> result = new ArrayDeque<>();
        List<JugadorValue> list = new LinkedList<>();
        List<JugadorValue> listC = new LinkedList<>();
        jugadores.forEach((jugador) -> {
//            System.out.println("@@## JugadorName > "+jugador.getName());
            if(jugador instanceof CabezaSerie){
                listC.add(jugador);
            }else{
                list.add(jugador);
            }
        });
        int counter = 0;
        int aux = Math.round(list.size()/listC.size());
//        System.out.println("@@## list > "+list.size()+" listC > "+listC.size());
                
                
        while(!listC.isEmpty() || !list.isEmpty()){
//            System.out.println(" @@## aux >> "+aux+" > % > "+counter%aux);
            int aleatorio1 =  (int) Math.floor(Math.random()*(list.size()));
            int aleatorio =  (int) Math.floor(Math.random()*(listC.size()));
            JugadorValue jugador = null ;
            if(counter%aux==0&&!listC.isEmpty()){
                jugador = listC.remove(aleatorio);
            }else{
                jugador = list.remove(aleatorio1);
            }
            if(jugador!=null){
                result.add(jugador);
            }
            counter++;
        }
       
        return result;
    }
    
}
