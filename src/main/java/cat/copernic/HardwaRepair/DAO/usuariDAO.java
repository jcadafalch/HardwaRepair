package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Usuari;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lktol
 */
public interface UsuariDAO extends CrudRepository<Usuari, Long>{
    /*Mètode que retornarà l'usuari que passem per paràmetre. 
    *El nom d'aquest mètode ha de ser findByUsername, ja que és el que reconeix Spring Boot
    *com a mètode de seguretat per recuperar l'usuari.
    */
    Usuari findByUsername(String username);

}
