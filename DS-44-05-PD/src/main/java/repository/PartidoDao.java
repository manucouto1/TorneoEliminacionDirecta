package repository;

import java.util.List;

import dominio.entidades.Partido;
import new_tech_dev.development.base_dao.GenericDao;

public interface PartidoDao extends GenericDao<Partido>{
	
	public List<Partido> findByTorneo(Integer torneo);
}
