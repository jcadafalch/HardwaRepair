/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.Utils.IsAdministrator;
import cat.copernic.HardwaRepair.serveis.Usuari.UsuariServiceInterface;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jcadafalch
 */
public class ControladorSeleccioModul {

    @Autowired
    private UsuariServiceInterface usuariService;

    @GetMapping("/SelectModule")
    public String selectModule(Model model, @AuthenticationPrincipal User username) {
        //log.info("Executant el controlador Spring MVC");
        //log.info("L'usuari autenticat és: " + username);
        //Passem a la vista si l'usuari és administrador
        model.addAttribute("isAdministrator", IsAdministrator.isAdministrator(username.getUsername(), usuariService));
        //Passem a la vista el nom de l'usuari en cas que no estigui autenticat ho indiquem
        if (username == null) {
            model.addAttribute("username", " Usuari no autenticat");
        } else {
            model.addAttribute("username", username.getUsername());
        }
        return "selectModule";
    }

    @GetMapping("/LlistatIncidencies")
    public String llistarIncidencies() {
        return "llistarincidencies";
    }

    @GetMapping("GestioUsuaris")
    public String gestioUsuaris() {
        return "gestioUsuaris";
    }
}
