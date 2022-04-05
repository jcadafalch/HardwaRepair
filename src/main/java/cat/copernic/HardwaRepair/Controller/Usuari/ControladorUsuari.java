package cat.copernic.HardwaRepair.Controller.Usuari;

import cat.copernic.HardwaRepair.Model.Usuari;
import cat.copernic.HardwaRepair.serveis.UsuariServiceInterface;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Lucas Tolón Pacheco
 */
@Controller
@Slf4j
public class ControladorUsuari {
    @Autowired
    private UsuariServiceInterface usuariService;

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
        }catch (NullPointerException e){
            System.out.println("No hi ha usuaris");
            System.out.println("Error == " + e.getMessage());
        }



        return "formulariUsuaris";
    }
    
    @PostMapping("/guardarUsuari")
    public String guardarProducte(@Valid Usuari usuari, Errors errors){
        if (errors.hasErrors()) {
            log.info("S'ha produït un error'");
            return "formulariProducte";
        }
        
        usuariService.afegirUsuari(usuari);
        return "redirect:/llistarUsuaris";
    }

    /*@GetMapping("/editarProducte/{idProducte}")
    public String editarProducte(Producte producte, Model model){
        System.out.println("Hola");
        System.out.println("Producte a editar == " + producte);
        //log.info(String.valueOf(producte.getIdProducte()));

        producte = producteService.cercarProducte(producte);
        System.out.println("Producte a editar == " + producte);
        model.addAttribute("producte", producte);
        model.addAttribute("categories", categoriaService.llistarCategoria());
        return "formulariProducte";
    }*/
}
