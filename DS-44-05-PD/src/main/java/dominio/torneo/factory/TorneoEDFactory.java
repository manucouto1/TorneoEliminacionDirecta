/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.factory;

import dominio.entidades.tipos.TournmentType;
import dominio.entidades.torneo.TorneoED;
import dominio.entidades.torneo.TorneoValue;

/**
 *
 * @author manuc
 */
public class TorneoEDFactory extends TorneoFactory{

    @Override
    public TorneoValue get() {
        return new TorneoED(TournmentType.TED);
    }
    
}
