package cat.copernic.HardwaRepair.serveis.Producte;

import cat.copernic.HardwaRepair.Model.Producte;
import java.util.List;

/**
 *
 * @author jcadafalch
 */
public interface ProducteServiceInterface {

    //Mètode que implementarem per llistar productes
    public List<Producte> llistarProductes();

    // Mètode que implementarem per afegir un producte
    public void afegirProducte(Producte producte);

    //Mètode que implementarem per eliminar un producte
    public void eliminarProducte(Producte producte);

    //Mètode que implementarem per cercar un producte
    public Producte cercarProducte(Producte producte);

    //Mètode que implementarem per cercar un producte per ID
    public Producte cercarProducteById(Long id);
}
