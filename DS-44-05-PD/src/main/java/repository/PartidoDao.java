package repository;

import java.util.List;

import dominio.entidades.Partido;
import new_tech_dev.development.base_shit.base_dao.GenericDao;

public interface PartidoDao extends GenericDao<Partido,Integer>{
	
	public List<Partido> findByTorneo(Integer torneo);
}
