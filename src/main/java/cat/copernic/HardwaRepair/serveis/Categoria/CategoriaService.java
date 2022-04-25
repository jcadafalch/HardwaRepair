package cat.copernic.HardwaRepair.serveis.Categoria;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.Categoria;
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
public class CategoriaService implements CategoriaServiceInterface{

    @Autowired
    private CategoriaDAO categoria;

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> llistarCategoria() {
        return (List<Categoria>) categoria.findAll();
    }

    /*Afegir el categoria passat per paràmetre a la taula categoria de la BBDD veterinari*/
    @Override
    @Transactional
    public void afegirCategoria(Categoria categoria) {
        this.categoria.save(categoria);
    }

    /*Eliminar el categoria passat per paràmetre de la taula categoria de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegircategoria, modifiquem la informació de la BBDD
    public void eliminarCategoria(Categoria categoria) {
        this.categoria.delete(categoria);
    }

    /*Cercar el categoria passat per paràmetre en la taula categoria de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llista Categories, no modifiquem la informació de la BBDD
    public Categoria cercarCategoria(Categoria categoria) {
        return this.categoria.findById(categoria.getIdCategoria()).orElse(null);

    }

    @Override
    public Categoria cercarCategoriaByID(Long id) {
        return this.categoria.findById(id).orElse(null);
    }


}