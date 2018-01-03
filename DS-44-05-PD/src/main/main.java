/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import cache.TournmentCache;
import new_tech_dev.development.container.Container;
import repository.JugadorDao;
import repository.PartidoDao;

/**
 *
 * @author manuc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    	
    	Container c = new Container();
    	c.put(JugadorDao.class);
    	c.put(PartidoDao.class);
    	
    	TournmentCache cache = new TournmentCache(c);
    	
    	
    	
    	
    	
    }
    
    
}
