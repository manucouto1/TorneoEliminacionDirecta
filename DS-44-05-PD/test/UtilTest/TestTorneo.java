/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilTest;

import contenedor.Container;
import dominio.Torneo;
import dominio.estado.State;
import dominio.jugador.CabezaSerie;
import dominio.jugador.Jugador;
import dominio.tipos.TournmentType;
import manager.TorneoManager;
import manager.impl.TorneoManagerImpl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import matcher.Matcher;
import matcher.RandomeMatcher;
import matcher.SeededMatcher;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author manuc
 */
public class TestTorneo {
    
    private Container c = new Container();
    private Torneo t;
    private TorneoManager tmng = new TorneoManagerImpl();
    
    @Test
    public void tesCreateTorneoTEDTrue() throws Exception {
        assertTrue(tmng.crearTorneo(c, "testTorneo", TournmentType.TED));
    }
    
    @Test
    public void tesCreateTorneoTEDFalse() throws Exception {
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        assertTrue(!tmng.crearTorneo(c, "testTorneo", TournmentType.TED));
    }
    
    @Test
    public void tesGetTorneo() throws Exception {
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        assertTrue(null != tmng.seleccionarTorneo(c, "testTorneo"));
    }
    
    
    @Test
    public void tesGetTorneoException() throws Exception {
        try{
            t = tmng.seleccionarTorneo(c, "testTorneo");
            //fail("Expected an non existin tourment exception");
        }catch(Exception e){
            assertThat(e.getMessage(), is("  Error: No existe este torneo"));
        }
    }
    
    @Test
    public void testInscribirJugador() {
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        Jugador p = new Jugador("1",18);
        tmng.inscribirJugador(t,p);
        assertEquals(t.getJugadores().getFirst(),p);
    }
    
    @Test
    public void testInscribirJugadores() {
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        List<Jugador> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new Jugador("4",18), new Jugador("5",18), new Jugador("6",18), 
                new Jugador("7",18), new Jugador("8",18), new Jugador("9",18), 
                new Jugador("10",18), new Jugador("11",18), new Jugador("12",18), 
                new Jugador("13",18), new Jugador("14",18), new Jugador("15",18), 
                new Jugador("16",18));
        Deque<Jugador> list = new ArrayDeque<>(test0);
        tmng.inscribirJugadores(t, test0);
        assertEquals(t.getJugadores().size(),list.size());
    }
    
    @Test 
    public void testPrepararTorneo() throws Exception{
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<Jugador> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new Jugador("4",18), new Jugador("5",18), new Jugador("6",18), 
                new Jugador("7",18), new Jugador("8",18), new Jugador("9",18), 
                new Jugador("10",18), new Jugador("11",18), new Jugador("12",18), 
                new Jugador("13",18), new Jugador("14",18), new Jugador("15",18), 
                new Jugador("16",18));
        tmng.inscribirJugadores(t, test0);
        tmng.prepararTorneo(t);
        assertEquals(t.getEstado(), State.NO_JUGADO);
    }
    
    @Test 
    public void testPreparaTorneoException() {
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        Matcher matcher = new RandomeMatcher();
        t.setMatcher(matcher);
        List<Jugador> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new Jugador("4",18), new Jugador("5",18), new Jugador("6",18), 
                new Jugador("7",18), new Jugador("8",18), new Jugador("9",18), 
                new Jugador("10",18), new Jugador("11",18), new Jugador("12",18), 
                new Jugador("13",18), new Jugador("14",18), new Jugador("15",18));
        tmng.inscribirJugadores(t, test0);
        try {
            tmng.prepararTorneo(t);
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Numero de jugadores invalido"));
            
        }
    }
    
    @Test
    public void testIniciarTorneo() throws Exception{
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<Jugador> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new Jugador("4",18), new Jugador("5",18), new Jugador("6",18), 
                new Jugador("7",18), new Jugador("8",18), new Jugador("9",18), 
                new Jugador("10",18), new Jugador("11",18), new Jugador("12",18), 
                new Jugador("13",18), new Jugador("14",18), new Jugador("15",18), 
                new Jugador("16",18));
        tmng.inscribirJugadores(t, test0);
        tmng.prepararTorneo(t);
        assertTrue(tmng.iniciarTorneo(t));
    }
    
    @Test
    public void testIniciarTorneoException() {
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<Jugador> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new Jugador("4",18), new Jugador("5",18), new Jugador("6",18), 
                new Jugador("7",18), new Jugador("8",18), new Jugador("9",18), 
                new Jugador("10",18), new Jugador("11",18), new Jugador("12",18), 
                new Jugador("13",18), new Jugador("14",18), new Jugador("15",18), 
                new Jugador("16",18));
        tmng.inscribirJugadores(t, test0);
        try{
        assertEquals(false, tmng.iniciarTorneo(t));
        }catch(Exception e){
            assertThat(e.getMessage(), is("Error: El torneo esta en espera"));
        }
    }
    
    @Test
    public void testPrintTabla() throws Exception{
        tmng.crearTorneo(c, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(c, "testTorneo");
        Matcher matcher = new SeededMatcher();
        t.setMatcher(matcher);
        List<Jugador> test0 = Arrays.asList(new CabezaSerie.Builder("1",18).build(), 
                new CabezaSerie.Builder("2",18).build(), new CabezaSerie.Builder("3",18).build(), 
                new Jugador("4",18), new Jugador("5",18), new Jugador("6",18), 
                new Jugador("7",18), new Jugador("8",18), new Jugador("9",18), 
                new Jugador("10",18), new Jugador("11",18), new Jugador("12",18), 
                new Jugador("13",18), new Jugador("14",18), new Jugador("15",18), 
                new Jugador("16",18));
        tmng.inscribirJugadores(t, test0);
        tmng.prepararTorneo(t);
        tmng.iniciarTorneo(t);
        tmng.printTable(t);
        
        
    }
    
}
