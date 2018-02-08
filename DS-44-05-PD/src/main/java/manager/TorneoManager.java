
package manager;

import java.util.List;

import cache.TournmentCache;
import dominio.entidades.tipos.TournmentType;
import dominio.entidades.torneo.TorneoValue;
import dominio.jugador.JugadorValue;


/**
 *
 * @author mcouto
 */
public interface TorneoManager{
    
   public boolean crearTorneo(TournmentCache c, String name, TournmentType tipo);
   public TorneoValue seleccionarTorneo(TournmentCache c, String nombre);
   public <T extends JugadorValue> void inscribirJugador(TorneoValue torneo, T jugador);
   public <T extends JugadorValue> void inscribirJugadores(TorneoValue torneo, List<T> jugadores);
   public void prepararTorneo(TorneoValue t) throws Exception;
   public boolean iniciarTorneo(TorneoValue t)throws Exception; 
   public void printTable(TorneoValue t)throws Exception;
  
    
}
