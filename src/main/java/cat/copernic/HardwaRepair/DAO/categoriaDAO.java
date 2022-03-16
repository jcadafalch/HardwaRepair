/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.DAO;

import cat.copernic.HardwaRepair.Model.categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lktol
 */
public interface categoriaDAO extends CrudRepository<categoria, String>{
    
}