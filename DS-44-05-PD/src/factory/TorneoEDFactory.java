/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dominio.Torneo;
import dominio.TorneoED;
import dominio.tipos.TournmentType;

/**
 *
 * @author manuc
 */
public class TorneoEDFactory extends TorneoFactory{

    @Override
    public Torneo get() {
        return new TorneoED(TournmentType.TED);
    }
    
}
