package cat.copernic.HardwaRepair.serveis.LiniaReparacio;

import cat.copernic.HardwaRepair.Model.LiniaReparacio;
import java.util.List;

/**
 *
 * @author jcadafalch
 */
public interface LiniaReparacioServiceInterface {

    //Mètode que implementarem per llistar totes les linies de reparació
    public List<LiniaReparacio> llistarLiniaReparacio();

    //Mètode que implementarem per afegir una linia de reparació
    public void afegirLiniaReparacio(LiniaReparacio liniaReparacio);

    //Mètode que implementarem per eliminar una linia de reparació
    public void eliminarLiniaReparacio(LiniaReparacio liniaReparacio);

}
