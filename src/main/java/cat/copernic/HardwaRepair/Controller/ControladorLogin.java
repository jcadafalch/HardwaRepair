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
