package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Categoria;
import java.util.List;

/**
 *
 * @author jcadafalch
 */
public interface CategoriaServiceInterface {


    public List<Categoria> llistarCategoria(); //Mètode que implementarem per llistar Categories

    public void afegirCategoria(Categoria categoria); //Mètode que implementarem per afegir un categoria

    public void eliminarCategoria(Categoria categoria); //Mètode que implementarem per eliminar un categoria

    public Categoria cercarCategoria(Categoria categoria); //Mètode que implementarem per cercar un categoria


}
