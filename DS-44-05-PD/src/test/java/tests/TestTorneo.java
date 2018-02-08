/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cache.TournmentCache;
import dominio.entidades.estado.State;
import dominio.entidades.tipos.TournmentType;
import dominio.entidades.torneo.TorneoValue;
import dominio.jugador.CabezaSerie;
import dominio.jugador.JugadorValue;
import dominio.torneo.matcher.Matcher;
import dominio.torneo.matcher.RandomeMatcher;
import dominio.torneo.matcher.SeededMatcher;
import manager.TorneoManager;
import manager.impl.TorneoManagerImpl;
import new_tech_dev.development.container.Container;

/**
 *
 * @author manuc
 */
public class TestTorneo {
    
	private Container c = new Container();
    private TournmentCache cache;
    private TorneoValue t;
    private TorneoManager tmng = new TorneoManagerImpl();
    
    @Before
    public void pre() throws Exception{
    	cache = new TournmentCache(c);
    }
    @Test
    public void tesCreateTorneoTEDTrue() throws Exception {
        assertTrue(tmng.crearTorneo(cache, "testTorneo", TournmentType.TED));
    }
    
    @Test
    public void tesCreateTorneoTEDFalse() throws Exception {
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        assertTrue(!tmng.crearTorneo(cache, "testTorneo", TournmentType.TED));
    }
    
    @Test
    public void tesGetTorneo() throws Exception {
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        assertTrue(null != tmng.seleccionarTorneo(cache, "testTorneo"));
    }
    
    
    @Test
    public void tesGetTorneoException() throws Exception {
        try{
            t = tmng.seleccionarTorneo(cache, "testTorneo");
            //fail("Expected an non existin tourment exception");
        }catch(Exception e){
            assertThat(e.getMessage(), is("  Error: No existe este torneo"));
        }
    }
    
    @Test
    public void testInscribirJugador() {
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        JugadorValue p = new JugadorValue("1",18);
        tmng.inscribirJugador(t,p);
        assertEquals(t.getJugadores().getFirst(),p);
    }
    
    @Test
    public void testInscribirJugadores() {
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        List<JugadorValue> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new JugadorValue("4",18), new JugadorValue("5",18), new JugadorValue("6",18), 
                new JugadorValue("7",18), new JugadorValue("8",18), new JugadorValue("9",18), 
                new JugadorValue("10",18), new JugadorValue("11",18), new JugadorValue("12",18), 
                new JugadorValue("13",18), new JugadorValue("14",18), new JugadorValue("15",18), 
                new JugadorValue("16",18));
        Deque<JugadorValue> list = new ArrayDeque<>(test0);
        tmng.inscribirJugadores(t, test0);
        assertEquals(t.getJugadores().size(),list.size());
    }
    
    @Test 
    public void testPrepararTorneo() throws Exception{
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<JugadorValue> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new JugadorValue("4",18), new JugadorValue("5",18), new JugadorValue("6",18), 
                new JugadorValue("7",18), new JugadorValue("8",18), new JugadorValue("9",18), 
                new JugadorValue("10",18), new JugadorValue("11",18), new JugadorValue("12",18), 
                new JugadorValue("13",18), new JugadorValue("14",18), new JugadorValue("15",18), 
                new JugadorValue("16",18));
        tmng.inscribirJugadores(t, test0);
        tmng.prepararTorneo(t);
        assertEquals(t.getEstado(), State.NO_JUGADO);
    }
    
    @Test 
    public void testPreparaTorneoException() {
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        Matcher matcher = new RandomeMatcher();
        t.setMatcher(matcher);
        List<JugadorValue> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new JugadorValue("4",18), new JugadorValue("5",18), new JugadorValue("6",18), 
                new JugadorValue("7",18), new JugadorValue("8",18), new JugadorValue("9",18), 
                new JugadorValue("10",18), new JugadorValue("11",18), new JugadorValue("12",18), 
                new JugadorValue("13",18), new JugadorValue("14",18), new JugadorValue("15",18));
        tmng.inscribirJugadores(t, test0);
        try {
            tmng.prepararTorneo(t);
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Numero de jugadores invalido"));
            
        }
    }
    
    @Test
    public void testIniciarTorneo() throws Exception{
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<JugadorValue> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new JugadorValue("4",18), new JugadorValue("5",18), new JugadorValue("6",18), 
                new JugadorValue("7",18), new JugadorValue("8",18), new JugadorValue("9",18), 
                new JugadorValue("10",18), new JugadorValue("11",18), new JugadorValue("12",18), 
                new JugadorValue("13",18), new JugadorValue("14",18), new JugadorValue("15",18), 
                new JugadorValue("16",18));
        tmng.inscribirJugadores(t, test0);
        tmng.prepararTorneo(t);
        assertTrue(tmng.iniciarTorneo(t));
    }
    
    @Test
    public void testIniciarTorneoException() {
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<JugadorValue> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new JugadorValue("4",18), new JugadorValue("5",18), new JugadorValue("6",18), 
                new JugadorValue("7",18), new JugadorValue("8",18), new JugadorValue("9",18), 
                new JugadorValue("10",18), new JugadorValue("11",18), new JugadorValue("12",18), 
                new JugadorValue("13",18), new JugadorValue("14",18), new JugadorValue("15",18), 
                new JugadorValue("16",18));
        tmng.inscribirJugadores(t, test0);
        try{
        assertEquals(false, tmng.iniciarTorneo(t));
        }catch(Exception e){
            assertThat(e.getMessage(), is("Error: El torneo esta en espera"));
        }
    }
    
    @Test
    public void testPrintTabla() throws Exception{
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<JugadorValue> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new JugadorValue("4",18), new JugadorValue("5",18), new JugadorValue("6",18), 
                new JugadorValue("7",18), new JugadorValue("8",18), new JugadorValue("9",18), 
                new JugadorValue("10",18), new JugadorValue("11",18), new JugadorValue("12",18), 
                new JugadorValue("13",18), new JugadorValue("14",18), new JugadorValue("15",18), 
                new JugadorValue("16",18));
        tmng.inscribirJugadores(t, test0);
        tmng.prepararTorneo(t);
        tmng.iniciarTorneo(t);
        tmng.printTable(t);
        
        
    }
    
}
