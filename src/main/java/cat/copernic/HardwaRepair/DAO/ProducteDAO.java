package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Producte;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author jcadafalch
 */
public interface ProducteDAO extends CrudRepository<Producte, Long>{
    public Producte findByNom(String nom);
}
