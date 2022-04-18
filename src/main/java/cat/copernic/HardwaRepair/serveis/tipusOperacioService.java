package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.tipusOperacio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cat.copernic.HardwaRepair.DAO.tipusOperacioDAO;

/**
 *
 * @author marc
 */


@Service
public class tipusOperacioService implements tipusOperacioServiceInterface{

    @Autowired
    private tipusOperacioDAO tipusOperacio;

    @Override
    @Transactional(readOnly=true)
    public List<tipusOperacio> llistartipusOperacio() {
        return (List<tipusOperacio>) tipusOperacio.findAll();
    }

    /*Afegir el tipusOperacio passat per paràmetre a la taula tipusOperacio de la BBDD veterinari*/
    @Override
    @Transactional
    public void afegirtipusOperacio(tipusOperacio tipusOperacio) {
        this.tipusOperacio.save(tipusOperacio);
    }

    /*Eliminar el tipusOperacio passat per paràmetre de la taula tipusOperacio de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegirtipusOperacio, modifiquem la informació de la BBDD
    public void eliminartipusOperacio(tipusOperacio tipusOperacio) {
        this.tipusOperacio.delete(tipusOperacio);
    }

    /*Cercar el tipusOperacio passat per paràmetre en la taula tipusOperacio de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llista Categories, no modifiquem la informació de la BBDD
    public tipusOperacio cercartipusOperacio(tipusOperacio tipusOperacio) {
        return this.tipusOperacio.findById(tipusOperacio.getId_tipus_operacio()).orElse(null);

    }

    @Override
    public tipusOperacio cercartipusOperacioByID(Long id) {
        return this.tipusOperacio.findById(id).orElse(null);
    }

}
