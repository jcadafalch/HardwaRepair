package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fta
 */

/*La interface JpaRepository, fa exactament el mateix que la interface CrudRepository, però amb millores,
 *així doncs, la classe GosDAO, també podria implementar JpaReposiitory en lloc de CrudRepository.
*/

/*Els tipus de classes que en el nostre cas utilitza CrudRepository són Usuari i Long, Usuari fa refèrencia a 
 *la classe que defineix l'entitat amb la que treballarem i Long el tipus de l'atribut que defineix la clau 
 *primaria d'aquesta entitat.
*/
    

public interface UsuariDAO extends JpaRepository<Usuari,Long>{ 
    
    /*Mètode que retornarà l'usuari que passem per paràmetre. 
    *El nom d'aquest mètode ha de ser findByUsername, ja que és el que reconeix Spring Boot
    *com a mètode de seguretat per recuperar l'usuari.
    */
    Usuari findByUsername(String username);
    
}
