package repository;

import java.util.List;

import dominio.entidades.Jugador;
import new_tech_dev.development.base_shit.base_dao.GenericDao;

public interface JugadorDao extends GenericDao<Jugador,Integer>{
	
	public List<Jugador> findByTorneo(Integer torneo);
	public int getAutoIncrementValue();
}
