package repository;

import java.util.List;

import dominio.entidades.Jugador;
import dominio.entidades.Torneo;
import new_tech_dev.development.base_dao.GenericDao;

public interface TorneoDao extends GenericDao<Torneo>{
	public void deleteByCode(String code);
	public Torneo findByCode(String code);
	public int getAutoIncrementValue();
	public void addJugador(Torneo torneo, Jugador jugador);
	public List<Integer> findJugadores(Torneo torneo);
} 
