package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Client;
import cat.copernic.HardwaRepair.Model.Equip;
import cat.copernic.HardwaRepair.Model.Incidencia;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marc
 */
public interface IncidenciaDAO extends CrudRepository<Incidencia,Long>{
    /*Mètode que retornarà el id de l'incidencia que passem per paràmetre.
     */
}
