package facade.torneo;

import java.util.List;

import torneo.TorneoValue;

public interface TorneoFacade {
	
	public void add(TorneoValue e);
	public TorneoValue findOne(TorneoValue e) throws Exception;
	public List<TorneoValue> findAll();
	public void delete(TorneoValue e);
	public void update(TorneoValue e);
	public void deleteByCode(String code);
	public TorneoValue findByCode(String code);
}
