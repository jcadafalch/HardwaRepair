package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.Tipus_EquipDAO;
import cat.copernic.HardwaRepair.Model.Tipus_Equip;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marc
 */


@Service
public class Tipus_EquipService implements Tipus_EquipServiceInterface{

    @Autowired
    private Tipus_EquipDAO tipus_equip;

    @Override
    @Transactional(readOnly=true)
    public List<Tipus_Equip> llistarTipus_Equip() {
        return (List<Tipus_Equip>) tipus_equip.findAll();
    }

    /*Afegir el tipus_equip passat per paràmetre a la taula tipus_equip de la BBDD veterinari*/
    @Override
    @Transactional
    public void afegirTipus_Equip(Tipus_Equip tipus_equip) {
        this.tipus_equip.save(tipus_equip);
    }

    /*Eliminar el tipus_equip passat per paràmetre de la taula tipus_equip de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegirtipus_equip, modifiquem la informació de la BBDD
    public void eliminarTipus_Equip(Tipus_Equip tipus_equip) {
        this.tipus_equip.delete(tipus_equip);
    }

    /*Cercar el tipus_equip passat per paràmetre en la taula tipus_equip de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llista Categories, no modifiquem la informació de la BBDD
    public Tipus_Equip cercarTipus_Equip(Tipus_Equip tipus_equip) {
        return this.tipus_equip.findById(tipus_equip.getId_tipus_equip()).orElse(null);

    }

    @Override
    public Tipus_Equip cercarTipus_EquipByID(Long id) {
        return this.tipus_equip.findById(id).orElse(null);
    }

}
