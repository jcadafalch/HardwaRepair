/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.Gos;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marc
 */
public interface ClientDAO extends CrudRepository<Gos,Long>{
    /*Mètode que retornarà l'usuari que passem per paràmetre. 
    *El nom d'aquest mètode ha de ser findByUsername, ja que és el que reconeix Spring Boot
    *com a mètode de seguretat per recuperar l'usuari.
    */
    Client findByUsername(String username);
}
