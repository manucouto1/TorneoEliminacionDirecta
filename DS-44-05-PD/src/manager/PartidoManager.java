/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dominio.Partido;
import dominio.Torneo;

/**
 *
 * @author mcouto
 */
public interface PartidoManager{
    
    public boolean preparePartido(String partido, Torneo torneo) throws Exception;
    
    public void setMarcador(Partido partido, int local, int visitante) throws Exception;
    
    public void iniciarPartido(Partido partido) throws Exception;
    
    public void finalizarPartido(Partido partido) throws Exception;
     
    public Partido findPartido(Torneo torneo, String code) throws Exception;
}