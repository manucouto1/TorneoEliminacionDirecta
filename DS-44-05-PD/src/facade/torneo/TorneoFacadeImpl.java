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
//			return convertTorneo(torneo2,e.getJugadores());
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
