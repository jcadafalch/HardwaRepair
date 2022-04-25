package cat.copernic.HardwaRepair.serveis.Incidencia;

import cat.copernic.HardwaRepair.DAO.IncidenciaDAO;
import cat.copernic.HardwaRepair.Model.Incidencia;
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
public class IncidenciaService implements IncidenciaServiceInterface{

    /*Quan treballem en la capa de servei amb classes de tipus DAO, com és el cas, estem
     *treballant amb transaccions SQL, és a dir, quan fem una consulta a la BBDD, si aquesta
     *ha estat un èxit, el sistema ha de fer un COMMIT, en cas contrari un ROLLBACK. Així doncs,
     *mitjançant anotacions, hem d'indicar al sistema de quin tipus de transacció és cadascun
     *dels mètodes per accedir a la BBDD que implementem en aquesta classe.
     */

    /*Atribut que defineix un incidenciaDAO. Mitjançant aquest atribut el control ja no
     *accedirà directament a la capa de dades, si no que accedirà mitjançant la capa de servei.
     */
    @Autowired
    private IncidenciaDAO incidencia;

    /*LListar incidencias de la taula incidencia de la BBDD hardawarepair*/
    @Override
    /*La notació @Transactional fa referència a la classe Transactional de Spring Framework.
     *En aquest cas no hi haurà ni COMMITS, ni ROLLBACKS, ja que no modifiquem la informació
     *de la BBDD, per tant, utilitzarem aquesta notació passant-li com a paràmetre readOnly=true
     *perquè només hem de llegir de la BBDD.
     */
    @Transactional(readOnly=true)
    public List<Incidencia> llistarIncidencies() {

        /*Cridem al mètode findAll() de CrudRepository perquè ens retorni el llistat de incidenciaos de la BBDD.
         *findAll() retorna un objecte, per tant hem de fer un cast perquè l'objecte sigui un List de incidenciasos
         */
        return (List<Incidencia>) incidencia.findAll();
    }

    /*Afegir el incidencia passat per paràmetre a la taula incidencia de la BBDD harwarepair*/
    @Override
    /*En aquest cas hi haurà COMMITS i ROLLBACKS, ja que modifiquem la informació de la BBDD, per tant,
     *utilitzarem aquesta notació sense passar-li cap paràmetre perquè es puguin fer els COMMITS
     *i ROLLBACKS.
     */
    @Transactional
    public void afegirIncidencia(Incidencia incidencia) {

        /*Cridem al mètode save() de CrudRepository perquè afegeixi el incidencia passat com a paràmetre,
         *a la taula incidencia de la BBDD hardwarepair.
         */
        this.incidencia.save(incidencia);
    }

    /*Eliminar el incidencia passat per paràmetre de la taula incidencia de la BBDD hardwarepair*/
    @Override
    @Transactional //Igual que en el mètode afegirIncidencia, modifiquem la informació de la BBDD
    public void eliminarIncidencia(Incidencia incidencia) {

        /*Cridem al mètode delete() de CrudRepository perquè elimini el incidencia passat com a paràmetre,
         *de la taula incidencia de la BBDD hardwarepair.
         */
        this.incidencia.delete(incidencia);
    }

    /*Cercar el equip passat per paràmetre en la taula Equips de la BBDD hardwarepair*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llistarIncidencias, no modifiquem la informació de la BBDD
    public Incidencia cercarIncidencia(Incidencia incidencia) {

        /*Cridem al mètode indByUsername() de CrudRepository perquè ens retorni el incidencia passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre
         *cas el incidencia.
         *
         *Si el incidencia no existei retornarà null (orElse(null)).
         */
        return this.incidencia.findById(incidencia.getId_incidencia()).orElse(null);
    }
}

