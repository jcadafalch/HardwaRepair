package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Equip;

import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface EquipServiceInterface {
    
    public List<Equip> llistarEquips(); //Mètode que implementarem per llistar equips
    
    public void afegirEquip(Equip equip); //Mètode que implementarem per afegir un equip
   
    public void eliminarEquip(Equip equip); //Mètode que implementarem per eliminar un equip
    
    public Equip cercarEquip(Equip equip); //Mètode que implementarem per cercar un equip
}
