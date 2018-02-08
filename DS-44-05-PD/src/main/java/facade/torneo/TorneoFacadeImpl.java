package facade.torneo;

import java.util.ArrayList;
import java.util.List;

import dominio.entidades.Jugador;
import dominio.entidades.Partido;
import dominio.entidades.Torneo;
import dominio.entidades.torneo.TorneoValue;
import dominio.jugador.JugadorValue;
import dominio.torneo.factory.Factory;
import new_tech_dev.development.container.Container;
import repository.JugadorDao;
import repository.PartidoDao;
import repository.TorneoDao;

public class TorneoFacadeImpl implements TorneoFacade{
	
	private TorneoDao torneoDao;
	private JugadorDao jugadorDao;
	private PartidoDao partidoDao;
	private Factory factory;
	
	public TorneoFacadeImpl (Container container){
		this.torneoDao = container.getDao(TorneoDao.class);
		this.jugadorDao = container.getDao(JugadorDao.class);
		this.partidoDao = container.getDao(PartidoDao.class);
		this.factory = new Factory();
	}

	@Override
	public Object add(TorneoValue e) {
		Torneo torneo = new Torneo.Builder(e).setId(torneoDao.getAutoIncrementValue()).build();
		try {
			Torneo torneo2 = (Torneo) torneoDao.add(torneo);
			for(JugadorValue jugadorValue : e.getJugadores()){
				Jugador jugador = new Jugador.Builder(jugadorValue).setId(jugadorDao.getAutoIncrementValue()).build();
				jugadorDao.add(jugador);
				torneoDao.addJugador(torneo, jugador);
			}
//			for(PartidoValue partidoValue : e.getPartidos()){
//				
//			}
			
			return convertTorneo(torneo2,new ArrayList<>(e.getJugadores()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public TorneoValue findOne(TorneoValue e) throws Exception {
		Torneo torneo = torneoDao.findOne(new Torneo.Builder(e).setId(e.getId()).build());
		List<Jugador> jugadorList = jugadorDao.findByTorneo(torneo.getId());
		List<JugadorValue> jugadoresValue = new ArrayList<JugadorValue>();
		for(Jugador jugador: jugadorList){
			jugadoresValue.add(new JugadorValue.Builder(jugador).setId(jugador.getId()).build());
		}
	
		return convertTorneo(torneo,jugadoresValue);
	}

	@Override
	public List<TorneoValue> findAll() {
		List<Torneo> torneosList = torneoDao.findAll();
		for(Torneo torneo : torneosList){
			 torneo.setJugadorList(jugadorDao.findByTorneo(torneo.getId()));
			 List<Partido> partidos = partidoDao.findByTorneo(torneo.getId());
		}
		
		
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
	
	private TorneoValue convertTorneo(Torneo torneo, List<JugadorValue> jugadoresValue) throws Exception {
		
		TorneoValue torneoValue = factory.getFactory(torneo.getTipo()).get();
		torneoValue.setCodigo((torneo.getCodigo()==null)?torneo.getCodigo():null);
		torneoValue.setId(torneo.getId());
		torneoValue.setTipo(torneo.getTipo());
		torneoValue.setEstado(torneo.getEstado());
		torneoValue.setJugadores(jugadoresValue);
		return torneoValue;
	}
	

}
