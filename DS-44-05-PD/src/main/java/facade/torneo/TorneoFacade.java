package facade.torneo;

import java.util.List;

import dominio.entidades.torneo.TorneoValue;

public interface TorneoFacade {
	
	public Object add(TorneoValue e);
	public TorneoValue findOne(TorneoValue e) throws Exception;
	public List<TorneoValue> findAll();
	public void delete(TorneoValue e);
	public void update(TorneoValue e);
	public void deleteByCode(String code);
	public TorneoValue findByCode(String code);
}
