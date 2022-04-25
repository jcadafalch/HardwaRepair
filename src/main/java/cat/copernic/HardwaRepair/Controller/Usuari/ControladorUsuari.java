package cat.copernic.HardwaRepair.Controller.Usuari;

import cat.copernic.HardwaRepair.DAO.UsuariCrudDAO;
import cat.copernic.HardwaRepair.Model.Usuari;
import cat.copernic.HardwaRepair.Eines.EncriptadorContrasenyes;
import javax.validation.Valid;
import cat.copernic.HardwaRepair.serveis.Usuari.UsuariServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




/**
 *
 * @author Lucas Tolón Pacheco
 */
@Controller
@Slf4j
public class ControladorUsuari {
    @Autowired
    private UsuariServiceInterface usuariService;
    @Autowired
    private UsuariCrudDAO usuariDAO;

    @GetMapping("/llistarUsuaris")
    public String llistarUsuaris(Model model) {
        {
            try {
                model.addAttribute("usuaris", usuariService.llistarUsuari());
            } catch (NullPointerException e) {
                System.out.println("No hi ha usuaris");
                System.out.println("Error == " + e.getMessage());
            }
            return "llistarUsuaris";
        }
    }

    @GetMapping("/formulariUsuari")
    public String crearFormulariUsuari(Usuari usuari, Model model){

        try{
            var usuaris = usuariService.llistarUsuari();
            System.out.println(usuaris);
            model.addAttribute("usuaris", usuaris);
            model.addAttribute("founded", false);
        }catch (NullPointerException e){
            System.out.println("No hi ha usuaris");
            System.out.println("Error == " + e.getMessage());
        }

        return "formulariUsuari";
    }
    
    @PostMapping("/guardarUsuari")
    public String guardarUsuari(@Valid Usuari usuari, @RequestParam(value = "password")String cont, Errors errors, RedirectAttributes redirectAttrs){
        //Guardamos en una variable la contraseña anterior que tenia el usuario
        String pass = usuari.getPassword();
        
        if(cont == null){ // En caso de que la contraseña no se haya editado
            usuari.setPassword(pass);// Guardaremos de nuevo la antigua
        } else {
            if(cont != null){// De haberse editado, la nueva la encriptaremos y guardaremos
                usuari.setPassword(EncriptadorContrasenyes.encriptarContrasenya(cont));
            }
        }
        
        if (errors.hasErrors()) {
            log.info("S'ha produït un error'");
            return "formulariUsuari";
        }
        
        if(usuariDAO.findByDni(usuari.getDni()) != null){
            redirectAttrs
            .addFlashAttribute("mensaje", "No pots crear dos usuaris amb el mateix DNI")
            .addFlashAttribute("clase", "error");
            return "redirect:/llistarUsuaris";
        }
        
        usuariService.afegirUsuari(usuari);
        return "redirect:/llistarUsuaris";
    }

    @GetMapping("/editarUsuari/{idUsuari}")
    public String editarUsuari(Usuari usuari, Model model, @AuthenticationPrincipal User username){
        usuari = usuariService.cercarUsuari(usuari);
        System.out.println("Ususari a editar == " + usuari);
        model.addAttribute("usuari", usuari);
        model.addAttribute("founded", true);
        //Passem a la vista si l'usuari és administrador
        //model.addAttribute("isAdministrator", IsAdministrator.isAdministrator(username.getUsername(), usuariService));

        return "formulariUsuari";
    }
    
    @GetMapping("/eliminarUsuari/{idUsuari}")
    public String eliminarUsuari(Usuari usuari){
        //Eliminem el usuari
        usuariService.eliminarUsuari(usuari);

        //Redirigim a la vista de llistar usuaris
        return "redirect:/llistarUsuaris";
    }
}
