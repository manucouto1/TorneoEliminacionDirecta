/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedor;

import dominio.Torneo;
//import dominio.TorneoED;
import dominio.tipos.TournmentType;
import factory.TorneoEDFactory;
import factory.TorneoFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manuc
 */
public class Container {
    
        private final Map<String, Torneo> tournments = new HashMap<>();
        private boolean empty = true;
//        private TorneoFactory factory;
        
        public boolean addTorneo(String nombre, TournmentType tipo) {
            this.empty = false;
            if(null != this.tournments.get(nombre)){
                return false;
            } else {
                this.tournments.put(nombre, (Torneo) getFactory(tipo).get());
                return true;
            }
        }
        
        public Torneo getTorneo(String nombre) throws Exception{
            if(null != this.tournments.get(nombre))
                return this.tournments.get(nombre);
            else {
                throw new Exception(" Error: No existe este torneo");
            }
        }
        
        public void listTorneos(){
            System.out.println("Torneos:                         ");
            this.tournments.entrySet().forEach((entry) -> {
                System.out.println(" - "+entry.getKey());
            });
        }
        
        private TorneoFactory getFactory(TournmentType tipo){
            if(tipo.equals(TournmentType.TED)){
                return new TorneoEDFactory();
            }else{
                return null;
            }
        }
        public boolean isEmpty(){
            return empty;
        }
}
