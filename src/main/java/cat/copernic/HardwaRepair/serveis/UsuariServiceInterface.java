package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Usuari;
import java.util.List;

/**
 *
 * @author jcadafalch
 */
public interface UsuariServiceInterface {
    
    public List<Usuari> llistarUsuari(); //Mètode que implementarem per llistar usuaris
    
    public void afegirUsuari(Usuari usuari); //Mètode que implementarem per afegir un usuari
    
    public void eliminarUsuari(Usuari usuari); //Mètode que implementarem per eliminar un usuari
    
    public Usuari cercarUsuari(Usuari usuari); //Mètode que implementarem per cercar un usuari
    
}
