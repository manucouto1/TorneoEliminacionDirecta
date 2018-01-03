package servicios.impl;

import java.util.List;

import dominio.entidades.Torneo;
import new_tech_dev.development.container.Container;
import repository.TorneoDao;
import servicios.TorneoServicio;
import torneo.TorneoValue;

public class TorneoServicioImpl implements TorneoServicio{
	
	private TorneoDao dao;
	
	public TorneoServicioImpl (Container container){
		dao = container.getDao(Torneo.class);
	}

	@Override
	public void add(TorneoValue e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TorneoValue findOne(TorneoValue e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TorneoValue> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TorneoValue e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TorneoValue e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCode(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TorneoValue findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
