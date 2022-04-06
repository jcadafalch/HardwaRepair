package cat.copernic.HardwaRepair.serveis.LiniaReparacio;

import cat.copernic.HardwaRepair.DAO.LiniaReparacioDAO;
import cat.copernic.HardwaRepair.Model.LiniaReparacio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 *
 * @author jcadafalch
 */
@Service
public class LiniaReparacioService implements LiniaReparacioServiceInterface{

    @Autowired
    private LiniaReparacioDAO liniaReparacio;

    //Llistar linies de reparació
    @Override
    @Transactional(readOnly = true)
    public List<LiniaReparacio> llistarLiniaReparacio() {
        return (List<LiniaReparacio>) liniaReparacio.findAll();
    }

    //Afegir linia de reparació
    @Override
    @Transactional
    public void afegirLiniaReparacio(LiniaReparacio liniaReparacio) {
        this.liniaReparacio.save(liniaReparacio);
    }

    //Eliminar linia de reparació
    @Override
    @Transactional
    public void eliminarLiniaReparacio(LiniaReparacio liniaReparacio) {
        this.liniaReparacio.delete(liniaReparacio);
    }
}
