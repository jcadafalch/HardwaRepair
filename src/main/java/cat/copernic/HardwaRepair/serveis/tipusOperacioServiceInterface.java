package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.tipusOperacio;
import java.util.List;

/**
 *
 * @author marc
 */
public interface tipusOperacioServiceInterface {


    public List<tipusOperacio> llistartipusOperacio(); //Mètode que implementarem per llistar Categories

    public void afegirtipusOperacio(tipusOperacio tipusOperacio); //Mètode que implementarem per afegir un tipusOperacio

    public void eliminartipusOperacio(tipusOperacio tipusOperacio); //Mètode que implementarem per eliminar un tipusOperacio

    public tipusOperacio cercartipusOperacio(tipusOperacio tipusOperacio); //Mètode que implementarem per cercar un tipusOperacio

    public tipusOperacio cercartipusOperacioByID(Long id); //Mètode que implementarem per cercar un tipusOperacio per ID

}
