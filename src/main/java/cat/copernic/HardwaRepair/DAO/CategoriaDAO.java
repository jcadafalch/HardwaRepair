package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lucas Tolón Pacheco
 */
public interface CategoriaDAO extends CrudRepository<Categoria, Long>{

    Categoria findByNom(String nom);

}