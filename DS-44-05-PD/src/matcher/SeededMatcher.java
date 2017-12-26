/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matcher;

import dominio.jugador.CabezaSerie;
import dominio.jugador.Jugador;
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
    public Deque<Jugador> matchPlayers(Deque<Jugador> jugadores) {
        Deque<Jugador> result = new ArrayDeque<>();
        List<Jugador> list = new LinkedList<>();
        List<Jugador> listC = new LinkedList<>();
        jugadores.forEach((jugador) -> {
            System.out.println("@@## JugadorName > "+jugador.getName());
            if(jugador instanceof CabezaSerie){
                listC.add(jugador);
            }else{
                list.add(jugador);
            }
        });
        int counter = 0;
        int aux = Math.round(list.size()/listC.size());
        System.out.println("@@## list > "+list.size()+" listC > "+listC.size());
                
                
        while(!listC.isEmpty() || !list.isEmpty()){
            System.out.println(" @@## aux >> "+aux+" > % > "+counter%aux);
            int aleatorio1 =  (int) Math.floor(Math.random()*(list.size()));
            int aleatorio =  (int) Math.floor(Math.random()*(listC.size()));
            Jugador jugador = null ;
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
    public Deque<Jugador> matchPlayers(List<Jugador> jugadores) {
        Deque<Jugador> result = new ArrayDeque<>();
        List<Jugador> list = new LinkedList<>();
        List<Jugador> listC = new LinkedList<>();
        jugadores.forEach((jugador) -> {
            System.out.println("@@## JugadorName > "+jugador.getName());
            if(jugador instanceof CabezaSerie){
                listC.add(jugador);
            }else{
                list.add(jugador);
            }
        });
        int counter = 0;
        int aux = Math.round(list.size()/listC.size());
        System.out.println("@@## list > "+list.size()+" listC > "+listC.size());
                
                
        while(!listC.isEmpty() || !list.isEmpty()){
            System.out.println(" @@## aux >> "+aux+" > % > "+counter%aux);
            int aleatorio1 =  (int) Math.floor(Math.random()*(list.size()));
            int aleatorio =  (int) Math.floor(Math.random()*(listC.size()));
            Jugador jugador = null ;
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
