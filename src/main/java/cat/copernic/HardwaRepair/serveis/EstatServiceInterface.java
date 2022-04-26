package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Estat;
import java.util.List;

/**
 *
 * @author marc
 */
public interface EstatServiceInterface {


    public List<Estat> llistarEstat(); //Mètode que implementarem per llistar Categories

    public void afegirEstat(Estat estat); //Mètode que implementarem per afegir un estat

    public void eliminarEstat(Estat estat); //Mètode que implementarem per eliminar un estat

    public Estat cercarEstat(Estat estat); //Mètode que implementarem per cercar un estat

    public Estat cercarEstatByID(Long id); //Mètode que implementarem per cercar un estat per ID

}
