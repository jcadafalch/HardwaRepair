package serveis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cat.copernic.HardwaRepair.DAO.categoriaDAO;
import cat.copernic.HardwaRepair.Model.categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Lucas Tolón Pacheco
 */

/*Anotació que permet al sistema que reconegui aquesta classe com una classe de servei
 *i que permet injectar aquesta classe en el controlador
*/
@Service
public class categroriaService implements categoriaServiceInterface {
        
    /*Quan treballem en la capa de servei amb classes de tipus DAO, com és el cas, estem
     *treballant amb transaccions SQL, és a dir, quan fem una consulta a la BBDD, si aquesta
     *ha estat un èxit, el sistema ha de fer un COMMIT, en cas contrari un ROLLBACK. Així doncs,
     *mitjançant anotacions, hem d'indicar al sistema de quin tipus de transacció és cadascun
     *dels mètodes per accedir a la BBDD que implementem en aquesta classe.    
    */
    
    /*Atribut que defineix un categoriaDAO. Mitjançant aquest atribut el control ja no 
     *accedirà directament a la capa de dades, si no que accedirà mitjançant la capa de servei.
    */
    @Autowired
    private categoriaDAO categoria; 

    /*LListar Categories de la taula categoria de la BBDD veterinari*/
    @Override
    /*La notació @Transactional fa referència a la classe Transactional de Spring Framework.
     *En aquest cas no hi haurà ni COMMITS, ni ROLLBACKS, ja que no modifiquem la informació
     *de la BBDD, per tant, utilitzarem aquesta notació passant-li com a paràmetre readOnly=true
     *perquè només hem de llegir de la BBDD.
    */    
    @Transactional(readOnly=true) 
    public List<categoria> llistarCategoria() {
        
        /*Cridem al mètode findAll() de CrudRepository perquè ens retorni el llistat de categoriaos de la BBDD.
         *findAll() retorna un objecte, per tant hem de fer un cast perquè l'objecte sigui un List de Categories
        */
        return (List<categoria>) categoria.findAll(); 
    }

    /*Afegir el categoria passat per paràmetre a la taula categoria de la BBDD veterinari*/
    @Override
    /*En aquest cas hi haurà COMMITS i ROLLBACKS, ja que modifiquem la informació de la BBDD, per tant,
     *utilitzarem aquesta notació sense passar-li cap paràmetre perquè es puguin fer els COMMITS 
     *i ROLLBACKS.
    */ 
    @Transactional
    public void afegirCategoria(categoria categoria) {
        
        /*Cridem al mètode save() de CrudRepository perquè afegeixi el categoria passat com a paràmetre,
         *a la taula categoria de la BBDD veterinari.
        */
        this.categoria.save(categoria); 
    }

    /*Eliminar el categoria passat per paràmetre de la taula categoria de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegircategoria, modifiquem la informació de la BBDD
    public void eliminarCategoria(categoria categoria) {
        
        /*Cridem al mètode delete() de CrudRepository perquè elimini el categoria passat com a paràmetre,
         *de la taula categoria de la BBDD veterinari.
        */
        this.categoria.delete(categoria);
        
    }

    /*Cercar el categoria passat per paràmetre en la taula categoria de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llista Categories, no modifiquem la informació de la BBDD
    public categoria cercarCategoria(categoria categoria) {
        
        /*Cridem al mètode findById() de CrudRepository perquè ens retorni el categoria passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre 
         *cas el categoria.
         *
         *Si el categoria no existei retornarà null (orElse(null)).
        */        
        return this.categoria.findById(categoria.getId()).orElse(null);
        
    }
    
}
