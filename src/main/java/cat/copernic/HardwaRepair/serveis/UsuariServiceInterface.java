package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Usuari;
import java.util.List;

/**
 *
 * @author jcadafalch
 */
public interface UsuariServiceInterface {
    
    public List<Usuari> llistarUsuari(); //Mètode que implementarem per llistar gossos
    
    public void afegirUsuari(Usuari usuari); //Mètode que implementarem per afegir un gos
    
    public void eliminarUsuari(Usuari usuari); //Mètode que implementarem per eliminar un gos
    
    public Usuari cercarUsuari(Usuari usuari); //Mètode que implementarem per cercar un gos
    
}
