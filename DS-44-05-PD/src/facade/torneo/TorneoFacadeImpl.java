package facade.torneo;

import java.util.ArrayList;
import java.util.List;

import dominio.entidades.Jugador;
import dominio.entidades.Torneo;
import dominio.jugador.JugadorValue;
import new_tech_dev.development.container.Container;
import repository.JugadorDao;
import repository.TorneoDao;
import torneo.TorneoValue;
import torneo.factory.Factory;

public class TorneoFacadeImpl implements TorneoFacade{
	
	private TorneoDao torneoDao;
	private JugadorDao jugadorDao;
	private Factory factory;
	
	public TorneoFacadeImpl (Container container){
		this.torneoDao = container.getDao(TorneoDao.class);
		this.jugadorDao = container.getDao(JugadorDao.class);
	}

	@Override
	public void add(TorneoValue e) {
		torneoDao.add(new Torneo.Builder(e).build());
	}

	@Override
	public TorneoValue findOne(TorneoValue e) throws Exception {
		
		Torneo torneo = torneoDao.findOne(new Torneo.Builder(e).setId(e.getId()).build());
		List<Jugador> jugadores = jugadorDao.findByTorneo(torneo.getId());
		List<JugadorValue>jugadoresValue = new ArrayList<>();
		for(Jugador jugador : jugadores){
			jugadoresValue.add(new JugadorValue.Builder(jugador)
					.setId(jugador.getId()).build());
		}
		TorneoValue torneoValue = factory.getFactory(torneo.getTipo()).get();
		torneoValue.setCodigo(torneo.getCodigo());
		torneoValue.setId(torneo.getId());
		torneoValue.setTipo(torneo.getTipo());
		torneoValue.setJugadores(jugadoresValue);
		
		return null;
	}

	@Override
	public List<TorneoValue> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TorneoValue e) {
		torneoDao.delete(new Torneo.Builder(e).build());
	}

	@Override
	public void update(TorneoValue e) {
		torneoDao.update(new Torneo.Builder(e).build());
		
	}

	@Override
	public void deleteByCode(String code) {
		torneoDao.deleteByCode(code);
	}

	@Override
	public TorneoValue findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
