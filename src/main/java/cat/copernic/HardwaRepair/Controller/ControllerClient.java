/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.ClientDAO;
import cat.copernic.HardwaRepair.DAO.GosDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jcadafalch
 */
@org.springframework.stereotype.Controller
@Slf4j
public class ControllerClient {
    @Autowired
    private ClientDAO clientDao; 

    @GetMapping("/controller")
    public String inici(Model model) {
        log.info("Executant el controlador de Client");
        
        //definim la variable gossos
        var clients = clientDao.findAll();
        
        model.addAttribute("clients", clients);

        return "inici"; 
    }
}
