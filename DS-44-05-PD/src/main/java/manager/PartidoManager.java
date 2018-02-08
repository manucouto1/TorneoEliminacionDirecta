/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dominio.entidades.torneo.TorneoValue;
import dominio.torneo.PartidoValue;

/**
 *
 * @author mcouto
 */
public interface PartidoManager{
    
    public boolean preparePartido(String partido, TorneoValue torneo) throws Exception;
    
    public void setMarcador(PartidoValue partido, int local, int visitante) throws Exception;
    
    public void iniciarPartido(PartidoValue partido) throws Exception;
    
    public void finalizarPartido(PartidoValue partido) throws Exception;
     
    public PartidoValue findPartido(TorneoValue torneo, String code) throws Exception;
}
