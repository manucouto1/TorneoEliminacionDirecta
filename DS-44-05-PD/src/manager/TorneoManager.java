
package manager;

import dominio.jugador.Jugador;
import dominio.tipos.TournmentType;
import torneo.Torneo;

import java.util.List;

import cache.TournmentCache;


/**
 *
 * @author mcouto
 */
public interface TorneoManager{
    
   public boolean crearTorneo(TournmentCache c, String name, TournmentType tipo);
   public Torneo seleccionarTorneo(TournmentCache c, String nombre);
   public <T extends Jugador> void inscribirJugador(Torneo torneo, T jugador);
   public <T extends Jugador> void inscribirJugadores(Torneo torneo, List<T> jugadores);
   public void prepararTorneo(Torneo t) throws Exception;
   public boolean iniciarTorneo(Torneo t)throws Exception; 
   public void printTable(Torneo t)throws Exception;
  
    
}
