package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Tipus_Equip;
import java.util.List;

/**
 *
 * @author marc
 */
public interface Tipus_EquipServiceInterface {


    public List<Tipus_Equip> llistarTipus_Equip(); //Mètode que implementarem per llistar Categories

    public void afegirTipus_Equip(Tipus_Equip tipus_equip); //Mètode que implementarem per afegir un tipus_equip

    public void eliminarTipus_Equip(Tipus_Equip tipus_equip); //Mètode que implementarem per eliminar un tipus_equip

    public Tipus_Equip cercarTipus_Equip(Tipus_Equip tipus_equip); //Mètode que implementarem per cercar un tipus_equip

    public Tipus_Equip cercarTipus_EquipByID(Long id); //Mètode que implementarem per cercar un tipus_equip per ID

}
