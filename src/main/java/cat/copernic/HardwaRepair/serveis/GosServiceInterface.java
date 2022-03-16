package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Gos;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface GosServiceInterface {
    
    public List<Gos> llistarGossos(); //Mètode que implementarem per llistar gossos
    
    public void afegirGos(Gos gos); //Mètode que implementarem per afegir un gos
    
    public void eliminarGos(Gos gos); //Mètode que implementarem per eliminar un gos
    
    public Gos cercarGos(Gos gos); //Mètode que implementarem per cercar un gos
}
