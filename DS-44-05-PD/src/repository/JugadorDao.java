package repository;

import java.util.List;

import dominio.entidades.Jugador;
import new_tech_dev.development.base_dao.GenericDao;

public interface JugadorDao extends GenericDao<Jugador>{
	
	public List<Jugador> findByTorneo(int torneo);
}
