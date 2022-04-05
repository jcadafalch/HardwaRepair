package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.Model.Client;

import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface ClientServiceInterface {
    
    public List<Client> llistarClients(); //Mètode que implementarem per llistar clients
    
    public void afegirClient(Client client); //Mètode que implementarem per afegir un client
    
    public void eliminarClient(Client client); //Mètode que implementarem per eliminar un client
    
    public Client cercarClient(Client client); //Mètode que implementarem per cercar un client
    
}
