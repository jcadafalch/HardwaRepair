package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.EquipDAO;
import cat.copernic.HardwaRepair.Model.Equip;
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
public class EquipService implements EquipServiceInterface {

    /*Quan treballem en la capa de servei amb classes de tipus DAO, com és el cas, estem
     *treballant amb transaccions SQL, és a dir, quan fem una consulta a la BBDD, si aquesta
     *ha estat un èxit, el sistema ha de fer un COMMIT, en cas contrari un ROLLBACK. Així doncs,
     *mitjançant anotacions, hem d'indicar al sistema de quin tipus de transacció és cadascun
     *dels mètodes per accedir a la BBDD que implementem en aquesta classe.    
     */
 /*Atribut que defineix un equipDAO. Mitjançant aquest atribut el control ja no 
     *accedirà directament a la capa de dades, si no que accedirà mitjançant la capa de servei.
     */
    @Autowired
    private EquipDAO equip;

    /*LListar equips de la taula equip de la BBDD hardwarepair*/
    @Override
    /*La notació @Transactional fa referència a la classe Transactional de Spring Framework.
     *En aquest cas no hi haurà ni COMMITS, ni ROLLBACKS, ja que no modifiquem la informació
     *de la BBDD, per tant, utilitzarem aquesta notació passant-li com a paràmetre readOnly=true
     *perquè només hem de llegir de la BBDD.
     */
    @Transactional(readOnly = true)
    public List<Equip> llistarEquips() {

        /*Cridem al mètode findAll() de CrudRepository perquè ens retorni el llistat de equipos de la BBDD.
         *findAll() retorna un objecte, per tant hem de fer un cast perquè l'objecte sigui un List de equipsos
         */
        return (List<Equip>) equip.findAll();
    }

    /*Afegir el equip passat per paràmetre a la taula equip de la BBDD hardwarepair*/
    @Override
    /*En aquest cas hi haurà COMMITS i ROLLBACKS, ja que modifiquem la informació de la BBDD, per tant,
     *utilitzarem aquesta notació sense passar-li cap paràmetre perquè es puguin fer els COMMITS 
     *i ROLLBACKS.
     */
    @Transactional
    public void afegirEquip(Equip equip) {

        /*Cridem al mètode save() de CrudRepository perquè afegeixi el equip passat com a paràmetre,
         *a la taula equip de la BBDD hardwarepair.*/
        this.equip.save(equip);
    }
 
    /*Eliminar el equip passat per paràmetre de la taula equip de la BBDD hardwarepair*/
    @Override
    @Transactional //Igual que en el mètode afegirEquip, modifiquem la informació de la BBDD
    public void eliminarEquip(Equip equip) {

        /*Cridem al mètode delete() de CrudRepository perquè elimini el equip passat com a paràmetre,
         *de la taula equip de la BBDD hardwarepair.
         */
        this.equip.delete(equip);

    }

    /*Cercar el equip passat per paràmetre en la taula equip de la BBDD hardwarepair*/
    @Override
    @Transactional(readOnly = true) //Igual que en el mètode llistarEquips, no modifiquem la informació de la BBDD
    public Equip cercarEquip(Equip equip) {

        /*Cridem al mètode findByUsername() de CrudRepository perquè ens retorni el equip passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre 
         *cas el equip.
         *
         *Si el equip no existei retornarà null (orElse(null)).
         */
        return this.equip.findById(equip.getNum_serie()).orElse(null);

    }

}
