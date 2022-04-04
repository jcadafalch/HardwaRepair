package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.UsuariDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Lucas Tolón Pacheco
 */
@Slf4j
public class usuariController {
    @Autowired
    private UsuariDAO usuariDAO;
    
    @GetMapping("/controller")
    public String inici(Model model) {
        log.info("Executant el controlador de Usuari");
        
        var usuaris = usuariDAO.findAll();
        
        model.addAttribute("usuaris", usuaris);
        
        return "inici";
    }
}
