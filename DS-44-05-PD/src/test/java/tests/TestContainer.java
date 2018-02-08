/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cache.TournmentCache;
import dominio.entidades.tipos.TournmentType;
import new_tech_dev.development.container.Container;

/**
 *
 * @author manuc
 */
public class TestContainer {
    
    @Test
    public void createTorunmentTest() throws Exception {
    	Container c = new Container();
        TournmentCache cache = new TournmentCache(c);
        assertTrue(cache.addTorneo("testTorneo", TournmentType.TED));
        assertTrue(null!=cache.getTorneo("testTorneo"));
        cache.listTorneos();
        
    }
    
    @Test
    public void createTorunmentYaExistenteTest() {
    	Container c = new Container();
        TournmentCache cache = new TournmentCache(c);
        
        cache.addTorneo("testTorneo", TournmentType.TED);
        try {
        	cache.getTorneo("testTorneo");
        } catch(Exception e){
            assertThat(e.getMessage(), is(" Error: No existe este torneo"));
        }
        
    }
}
