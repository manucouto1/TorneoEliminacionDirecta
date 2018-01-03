
package manager;

import dominio.jugador.Jugador;
import dominio.tipos.TournmentType;
import torneo.TorneoValue;

import java.util.List;

import cache.TournmentCache;


/**
 *
 * @author mcouto
 */
public interface TorneoManager{
    
   public boolean crearTorneo(TournmentCache c, String name, TournmentType tipo);
   public TorneoValue seleccionarTorneo(TournmentCache c, String nombre);
   public <T extends Jugador> void inscribirJugador(TorneoValue torneo, T jugador);
   public <T extends Jugador> void inscribirJugadores(TorneoValue torneo, List<T> jugadores);
   public void prepararTorneo(TorneoValue t) throws Exception;
   public boolean iniciarTorneo(TorneoValue t)throws Exception; 
   public void printTable(TorneoValue t)throws Exception;
  
    
}
