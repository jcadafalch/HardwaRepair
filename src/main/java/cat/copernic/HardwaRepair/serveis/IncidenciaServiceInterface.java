package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Incidencia;

import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface IncidenciaServiceInterface {
    
    public List<Incidencia> llistarIncidencies(); //Mètode que implementarem per llistar incidencias
    
    public void afegirIncidencia(Incidencia incidencia); //Mètode que implementarem per afegir una incidencia
    
    public void eliminarIncidencia(Incidencia incidencia); //Mètode que implementarem per eliminar una incidencia
    
    public Incidencia cercarIncidencia(Incidencia incidencia); //Mètode que implementarem per cercar una incidencia
    
}
