/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilTest;

import contenedor.Container;
import dominio.tipos.TournmentType;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author manuc
 */
public class TestContainer {
    
    @Test
    public void createTorunmentTest() throws Exception {
        Container c = new Container();
        assertTrue(c.addTorneo("testTorneo", TournmentType.TED));
        assertTrue(null!=c.getTorneo("testTorneo"));
        c.listTorneos();
        
    }
    
    @Test
    public void createTorunmentYaExistenteTest() {
        Container c = new Container();
        
        c.addTorneo("testTorneo", TournmentType.TED);
        try {
            c.getTorneo("testTorneo");
        } catch(Exception e){
            assertThat(e.getMessage(), is(" Error: No existe este torneo"));
        }
        
    }
}
