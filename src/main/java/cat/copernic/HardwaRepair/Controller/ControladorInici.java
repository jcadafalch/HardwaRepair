package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.Utils.IsAdministrator;
import cat.copernic.HardwaRepair.serveis.Usuari.UsuariServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import cat.copernic.HardwaRepair.Model.Usuari;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jcadafalch
 */
@Controller
@Slf4j
public class ControladorInici {

    @Autowired
    private UsuariServiceInterface usuariService;

    @GetMapping("/inici")
    public String iniciGet(Model model, @AuthenticationPrincipal User username) {
        System.out.println("Executant el controlador Spring MVC");
        System.out.println("L'usuari autenticat és: " + username);
        System.out.println("L'usuari autenticat és + getUsername: " + username.getUsername());

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

    @PostMapping("/inici")
    public String inici(Model model) {
        return "selectModule";
    }

}
