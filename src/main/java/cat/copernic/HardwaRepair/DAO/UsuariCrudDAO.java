package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Usuari;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jcadafalch
 */
public interface UsuariCrudDAO extends CrudRepository<Usuari,Long>{
    
    Usuari findByDni(String dni);
}
