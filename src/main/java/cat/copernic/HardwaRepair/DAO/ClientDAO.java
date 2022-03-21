
package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Client;
import cat.copernic.HardwaRepair.Model.Equip;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marc
 */
public interface ClientDAO extends CrudRepository<Client,String>{
    /*Mètode que retornarà el id del client que passem per paràmetre. 
    *El nom d'aquest mètode ha de ser findByUsername, ja que és el que reconeix Spring Boot
    *com a mètode de seguretat per recuperar l'usuari.
    */
        Client findByUsername(String username);
}
