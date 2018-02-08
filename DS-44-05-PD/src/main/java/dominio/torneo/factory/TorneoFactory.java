/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.factory;

import dominio.entidades.torneo.TorneoValue;

/**
 *
 * @author manuc
 */
public abstract class TorneoFactory {
    
    public abstract TorneoValue get();
        
      
}
