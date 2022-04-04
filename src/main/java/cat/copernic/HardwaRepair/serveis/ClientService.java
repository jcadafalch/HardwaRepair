package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.ClientDAO;
import cat.copernic.HardwaRepair.Model.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fta
 */

/*Anotació que permet al sistema que reconegui aquesta classe com una classe de servei
 *i que permet injectar aquesta classe en el controlador
*/
@Service 
public class ClientService implements ClientServiceInterface{
    
    /*Quan treballem en la capa de servei amb classes de tipus DAO, com és el cas, estem
     *treballant amb transaccions SQL, és a dir, quan fem una consulta a la BBDD, si aquesta
     *ha estat un èxit, el sistema ha de fer un COMMIT, en cas contrari un ROLLBACK. Així doncs,
     *mitjançant anotacions, hem d'indicar al sistema de quin tipus de transacció és cadascun
     *dels mètodes per accedir a la BBDD que implementem en aquesta classe.    
    */
    
    /*Atribut que defineix un clientDAO. Mitjançant aquest atribut el control ja no 
     *accedirà directament a la capa de dades, si no que accedirà mitjançant la capa de servei.
    */
    @Autowired
    private ClientDAO client; 

    /*LListar clients de la taula client de la BBDD hardawarepair*/
    @Override
    /*La notació @Transactional fa referència a la classe Transactional de Spring Framework.
     *En aquest cas no hi haurà ni COMMITS, ni ROLLBACKS, ja que no modifiquem la informació
     *de la BBDD, per tant, utilitzarem aquesta notació passant-li com a paràmetre readOnly=true
     *perquè només hem de llegir de la BBDD.
    */    
    @Transactional(readOnly=true) 
    public List<Client> llistarClients() {
        
        /*Cridem al mètode findAll() de CrudRepository perquè ens retorni el llistat de clientos de la BBDD.
         *findAll() retorna un objecte, per tant hem de fer un cast perquè l'objecte sigui un List de clientsos
        */
        return (List<Client>) client.findAll(); 
    }

    /*Afegir el client passat per paràmetre a la taula client de la BBDD harwarepair*/
    @Override
    /*En aquest cas hi haurà COMMITS i ROLLBACKS, ja que modifiquem la informació de la BBDD, per tant,
     *utilitzarem aquesta notació sense passar-li cap paràmetre perquè es puguin fer els COMMITS 
     *i ROLLBACKS.
    */ 
    @Transactional
    public void afegirClient(Client client) {
        
        /*Cridem al mètode save() de CrudRepository perquè afegeixi el client passat com a paràmetre,
         *a la taula client de la BBDD hardwarepair.
        */
        this.client.save(client); 
    }

    /*Eliminar el client passat per paràmetre de la taula client de la BBDD hardwarepair*/
    @Override
    @Transactional //Igual que en el mètode afegirClient, modifiquem la informació de la BBDD
    public void eliminarClient(Client client) {
        
        /*Cridem al mètode delete() de CrudRepository perquè elimini el client passat com a paràmetre,
         *de la taula client de la BBDD hardwarepair.
        */
        this.client.delete(client);
        
    }

    /*Cercar el equip passat per paràmetre en la taula Equips de la BBDD hardwarepair*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llistarClients, no modifiquem la informació de la BBDD
    public Client cercarClient(Client client) {
        
        /*Cridem al mètode indByUsername() de CrudRepository perquè ens retorni el client passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre 
         *cas el client.
         *
         *Si el client no existei retornarà null (orElse(null)).
        */ 

 return this.client.findById(client.getDni()).orElse(null);    
    }
    
}
