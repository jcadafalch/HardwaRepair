package serveis;

import cat.copernic.HardwaRepair.Model.categoria;
import java.util.List;

/**
 *
 * @author Lucas Tolón Pacheco
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface categoriaServiceInterface {
    
    public List<categoria> llistarCategoria(); //Mètode que implementarem per llistar Categories
    
    public void afegirCategoria(categoria categoria); //Mètode que implementarem per afegir un categoria
    
    public void eliminarCategoria(categoria categoria); //Mètode que implementarem per eliminar un categoria
    
    public categoria cercarCategoria(categoria categoria); //Mètode que implementarem per cercar un categoria
}
