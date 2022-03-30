/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Producte;
import java.util.List;

/**
 *
 * @author jcadafalch
 */
public interface ProducteServiceInterface {

    //Mètode que implementarem per llistar productes
    public List<Producte> llistarProduces();

    // Mètode que implementarem per afegir un producte
    public void afegirProducte(Producte producte);

    //Mètode que implementarem per eliminar un producte
    public void eliminarProducte(Producte producte);

    //Mètode que implementarem per cercar un producte
    public Producte cercarProducte(Producte producte);
}
