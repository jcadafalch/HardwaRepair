package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.EstatDAO;
import cat.copernic.HardwaRepair.Model.Estat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marc
 */


@Service
public class EstatService implements EstatServiceInterface{

    @Autowired
    private EstatDAO estat;

    @Override
    @Transactional(readOnly=true)
    public List<Estat> llistarEstat() {
        return (List<Estat>) estat.findAll();
    }

    /*Afegir el estat passat per paràmetre a la taula estat de la BBDD veterinari*/
    @Override
    @Transactional
    public void afegirEstat(Estat estat) {
        this.estat.save(estat);
    }

    /*Eliminar el estat passat per paràmetre de la taula estat de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegirestat, modifiquem la informació de la BBDD
    public void eliminarEstat(Estat estat) {
        this.estat.delete(estat);
    }

    /*Cercar el estat passat per paràmetre en la taula estat de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llista Categories, no modifiquem la informació de la BBDD
    public Estat cercarEstat(Estat estat) {
        return this.estat.findById(estat.getId_estat()).orElse(null);

    }

    @Override
    public Estat cercarEstatByID(Long id) {
        return this.estat.findById(id).orElse(null);
    }

}
