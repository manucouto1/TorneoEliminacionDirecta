package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import cache.TournmentCache;
import dominio.entidades.tipos.TournmentType;
import dominio.entidades.torneo.TorneoValue;
import dominio.jugador.CabezaSerie;
import dominio.jugador.JugadorValue;
import dominio.torneo.matcher.SeededMatcher;
import facade.torneo.TorneoFacadeImpl;
import manager.TorneoManager;
import manager.impl.TorneoManagerImpl;
import new_tech_dev.development.application_god.application_contaier.Container;
import repository.JugadorDao;
import repository.PartidoDao;
import repository.TorneoDao;
import tests.utiles.TestEntityDao;

public class PersistenceTest {
	
	private Container c = new Container();
	private TournmentCache cache;
	private TorneoValue t;
    private TorneoManager tmng = new TorneoManagerImpl();
    
	@Before
	public void pre() throws Exception {
		BasicConfigurator.configure();
    	c.put(JugadorDao.class);
    	c.put(PartidoDao.class);
    	c.put(TorneoDao.class);
    	c.put(TestEntityDao.class);
    	TestEntityDao testDao = c.getDao(TestEntityDao.class);
    	testDao.cleanDb();
    	cache = new TournmentCache(c);
    	tmng.crearTorneo(cache, "testTorneo", TournmentType.TED);
        t=tmng.seleccionarTorneo(cache, "testTorneo");
        t.setMatcher(new SeededMatcher());
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
    	
    	
    	
	}
	@Test
	public void torneoFacadeTest() throws Exception {
		TorneoFacadeImpl facade = new TorneoFacadeImpl(c);
		TorneoValue torneo = tmng.seleccionarTorneo(cache, "testTorneo");
		torneo.setId(((TorneoValue)facade.add(torneo)).getId());
		TorneoValue torneoPersisted = facade.findOne(tmng.seleccionarTorneo(cache, "testTorneo"));
		assertEquals(torneo.getId(),torneoPersisted.getId());
		assertEquals(torneo.getCodigo(),torneoPersisted.getCodigo());
		assertEquals(torneo.getEstado(),torneoPersisted.getEstado());
		assertEquals(torneo.getTipo(),torneoPersisted.getTipo());
		assertEquals(torneo.getJugadores().size(),torneoPersisted.getJugadores().size());
	}

}
