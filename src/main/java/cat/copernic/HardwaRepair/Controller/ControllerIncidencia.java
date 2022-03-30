/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.IncidenciaDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marc
 */


@Controller
@Slf4j
public class ControllerIncidencia {
    @Autowired
    private IncidenciaDAO incidenciaDao; 

    @GetMapping("/Incidencies")
    public String inici(Model model) {
        log.info("Executant el controlador de Incidencia");
        
        //definim la variable de l'incidencia
        var incidencies = incidenciaDao.findAll();
        
        model.addAttribute("incidencies", incidencies);

        return "inici"; 
        
    }
}
