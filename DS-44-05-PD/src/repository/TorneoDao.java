package repository;

import dominio.entidades.Torneo;
import new_tech_dev.development.base_dao.GenericDao;

public interface TorneoDao extends GenericDao<Torneo>{
	public void deleteByCode(String code);
	public Torneo findByCode(String code);
	public int getAutoIncrementValue();
} 
