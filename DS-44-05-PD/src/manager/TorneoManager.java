
package manager;

import contenedor.Container;
import dominio.Torneo;
import dominio.jugador.Jugador;
import dominio.tipos.TournmentType;
import java.util.List;


/**
 *
 * @author mcouto
 */
public interface TorneoManager{
    
   public boolean crearTorneo(Container c, String name, TournmentType tipo);
   public Torneo seleccionarTorneo(Container c, String nombre);
   public <T extends Jugador> void inscribirJugador(Torneo torneo, T jugador);
   public <T extends Jugador> void inscribirJugadores(Torneo torneo, List<T> jugadores);
   public void prepararTorneo(Torneo t) throws Exception;
   public boolean iniciarTorneo(Torneo t)throws Exception; 
   public void printTable(Torneo t)throws Exception;
  
    
}
