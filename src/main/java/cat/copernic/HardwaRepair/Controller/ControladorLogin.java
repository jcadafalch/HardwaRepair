/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jcadafalch
 */
@Controller
public class ControladorLogin {
    
    @GetMapping("/login")
    public String inici(Model model){
        return "login";
    }
    
    
}
