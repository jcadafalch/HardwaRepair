package serveis;

import cat.copernic.HardwaRepair.Model.categoria;
import java.util.List;

/**
 *
 * @author Lucas Tolón Pacheco
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface categoriaServiceInterface {
    
    public List<categoria> llistarCategoria(); //Mètode que implementarem per llistar gossos
    
    public void afegirCategoria(categoria categoria); //Mètode que implementarem per afegir un gos
    
    public void eliminarCategoria(categoria categoria); //Mètode que implementarem per eliminar un gos
    
    public categoria cercarCategoria(categoria categoria); //Mètode que implementarem per cercar un gos
}
