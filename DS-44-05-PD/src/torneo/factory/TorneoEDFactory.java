/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo.factory;

import dominio.tipos.TournmentType;
import torneo.TorneoValue;
import torneo.TorneoED;

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
