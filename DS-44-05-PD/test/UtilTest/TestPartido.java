/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilTest;

import dominio.Partido;
import dominio.estado.State;
import dominio.jugador.CabezaSerie;
import dominio.jugador.Jugador;
import dominio.tipos.TournmentType;
import manager.PartidoManager;
import manager.TorneoManager;
import manager.impl.PartidoManagerImpl;
import manager.impl.TorneoManagerImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import matcher.Matcher;
import matcher.SeededMatcher;
import new_tech_dev.development.container.Container;
import torneo.TorneoValue;
import treeModel.Nodo;
import treeModel.NodoPartido;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import cache.TournmentCache;

/**
 *
 * @author manuc
 */
public class TestPartido {
    private Container c;
    private TournmentCache cache;
    private TorneoValue t;
    private TorneoManager tmng = new TorneoManagerImpl();
    private PartidoManager pmng = new PartidoManagerImpl();
    
    @Before
    public void pre() throws Exception{
    	cache = new TournmentCache(c);
        tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
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
    }
    
    
    
    @Test
    public void testfindMatch() throws Exception{
        
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        List<Nodo> list = tabla.get(1);
        
        if((list.get(1) instanceof NodoPartido)){
            NodoPartido nodo = (NodoPartido) list.get(1);
            Partido partido = nodo.getPartido();
            assertEquals(partido, pmng.findPartido(t, partido.getCode()));
        }else{
            assertTrue(false);
        }
    } 
    
    @Test
    public void testfindMatchException() throws Exception{
        try{
            pmng.findPartido(t, "asfgadga");
        }catch(Exception e){
            assertThat(e.getMessage(), is("Partido no encontrado"));
        }
    }
    
    @Test
    public void testPrepararPartido1() throws Exception{
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        //
        pmng.preparePartido(partido.getCode(), t);
        assertEquals(partido.getState(), State.NO_JUGADO);
    }
    
    @Test
    public void testPrepararPartidoException() throws Exception{
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        //
        try{
            pmng.preparePartido(partido.getCode(), t);
        }catch(Exception e){
            assertThat(e.getMessage(), is("Numero de jugadores invalido"));
        }
    }
    
    @Test
    public void iniciarPartido() throws Exception {
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        //
        pmng.preparePartido(partido.getCode(), t);
        pmng.iniciarPartido(partido);
        assertEquals(partido.getState(), State.EN_JUEGO);
    }
    
    @Test
    public void iniciarPartidoException() {
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        //
        //pmng.preparePartido(partido.getCode(), t);
        try {
            pmng.iniciarPartido(partido);
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("ERROR: el partido esta EN_ESPERA"));
        }
    }
    
    @Test
    public void testSetMarcador() throws Exception{
        
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        //
        pmng.preparePartido(partido.getCode(), t);
        pmng.iniciarPartido(partido);
        pmng.setMarcador(partido, 3, 5);
        int local = partido.getMarcador().get(partido.getLocal());
        int visitante = partido.getMarcador().get(partido.getVisitante());
        assertEquals(local,3, 0.9);
        assertEquals(visitante,5, 0.9);
        
    }
    
    @Test
    public void testSetMarcadorException(){
        
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        //
        try{
            pmng.preparePartido(partido.getCode(), t);
            pmng.setMarcador(partido, 3, 5);
        } catch(Exception e){
            assertThat(e.getMessage(),is("Error: no se pueden poner resultados el Partido esta NO_JUGADO"));
        }
    }
    
    
    @Test
    public void finalizarPartido() throws Exception{
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        pmng.preparePartido(partido.getCode(), t);
        pmng.iniciarPartido(partido);
        pmng.setMarcador(partido, 3, 5);
        pmng.finalizarPartido(partido);
    }
    
    @Test
    public void finalizarPartidoException(){
        Map<Integer,List<Nodo>> tabla = t.getTabla();
        // En la aplicació veríamos el codigo en las tablas 
        List<Nodo> list = tabla.get(1);
        NodoPartido nodo = (NodoPartido) list.get(1);
        Partido partido = nodo.getPartido();
        try{
            pmng.preparePartido(partido.getCode(), t);
            pmng.iniciarPartido(partido);
            pmng.setMarcador(partido, 3, 3);
            pmng.finalizarPartido(partido);
        } catch(Exception e){
            assertThat(e.getMessage(), is("Alert: el partido esta jugandose tiempo añadido"));
        }
    }
}
