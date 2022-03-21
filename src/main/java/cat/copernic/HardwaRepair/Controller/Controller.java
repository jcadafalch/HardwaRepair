/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.usuariDAO;
import cat.copernic.HardwaRepair.Model.usuari;
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
public class Controller {
    @Autowired
    private usuariDAO usuariDAO;

    @GetMapping("/controller")
    public String inici(Model model) {
        log.info("Executant el controlador Spring MVC");
        
        //definim la variable gossos
        var usuaris = usuariDAO.findAll();
        
        model.addAttribute("usuaris", usuaris);

        return "inici"; 
    }
    
    @GetMapping("/formulariUsuari") //URL a la pàgina amb el formulari de les dades del usuari
    public String crearFormulariGos(usuari usuari) {

        return "formulariUsuari"; //Retorna la pàgina on es mostrarà el formulari de les dades dels usuaris
    }
}
