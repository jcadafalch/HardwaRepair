package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.ProducteDAO;
import cat.copernic.HardwaRepair.Model.Producte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jcadafalch
 */
@Service
public class ProducteService implements ProducteServiceInterface{
    
    @Autowired
    private ProducteDAO producte;

    // Llistar productes de la taula producte de la BBDD
    @Override
    @Transactional (readOnly = true)
    public List<Producte> llistarProductes() {
        return (List<Producte>) producte.findAll();
    }
    
    // Afegir el producte passat per paràmetre a la taula producte de la BBDD
    @Override
    @Transactional
    public void afegirProducte(Producte producte) {
        this.producte.save(producte);
    }

    // Eliminar el producte passat per paràmetre de la taula producte la BBDD
    @Override
    @Transactional
    public void eliminarProducte(Producte producte) {
        this.producte.delete(producte);
    }
    
    // Cercar el producte passat per paràmetre en la taula producte de la BBDD
    @Override
    @Transactional (readOnly = true)
    public Producte cercarProducte(Producte producte) {
        
        //Si el producte no existeix retornarà null ( orElse(null) )
        return this.producte.findById(producte.getIdProducte()).orElse(null);
    }

    @Override
    public Producte cercarProducteById(Long id) {
        return this.producte.findById(id).orElse(null);
    }

}
