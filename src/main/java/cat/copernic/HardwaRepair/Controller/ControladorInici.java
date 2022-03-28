package cat.copernic.HardwaRepair.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cat.copernic.HardwaRepair.Model.Usuari;
import cat.copernic.HardwaRepair.serveis.UsuariServiceInterface;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    //private UsuariServiceInterface usuariService;

    @GetMapping("/inici") //Arrel de l'aplicació localhost:8080
    public String iniciGet(Model model) {
        
        //Obtenim el username de l'usuari actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        
        //Omplim una llista amb tots els usuaris
        /*System.out.println("Hola AAAAA");
        System.out.println(usuariService.llistarUsuari().size());
        List<Usuari> arrUsuari = usuariService.llistarUsuari();
        
        //Busquem l'usuari que el seu username coincideixi amb el de l'usuari actual, i passem l'objecte d'aquell usuari a la vista
        arrUsuari.stream().filter(usuari -> (usuari.getUsername().equals(currentPrincipalName))).forEachOrdered(usuari -> {
            model.addAttribute("usuari", usuari);
        });*/
        
        return "selectModule";
    }

    @PostMapping("/inici")
    public String inici(Model model) {
        return "selectModule";
    }

}