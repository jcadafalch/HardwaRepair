package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Producte;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jcadafalch
 */
public interface ProducteDAO extends CrudRepository<Producte, Long>{
    
}
