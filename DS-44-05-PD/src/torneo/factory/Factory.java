package torneo.factory;

import dominio.tipos.TournmentType;

public class Factory {
	
	private final int TORNEO_ELIMINACION_DIRECTA = 1;
	private final int TORNEO_MULTY_FASE = 2;
	
	public TorneoFactory getFactory(TournmentType tipo) throws Exception{
		
		switch (tipo.getId()){
			case TORNEO_ELIMINACION_DIRECTA:
				return new TorneoEDFactory();
				
			case TORNEO_MULTY_FASE:
				throw new Exception(" -- ERROR: Un suported operation ");
				
			default: return null;
		}
	}
	
	public TorneoFactory getFactory(int tipo) throws Exception{
		
		switch (tipo){
			case TORNEO_ELIMINACION_DIRECTA:
				return new TorneoEDFactory();
				
			case TORNEO_MULTY_FASE:
				throw new Exception(" -- ERROR: Un suported operation ");
				
			default: return null;
		}
	}
}
