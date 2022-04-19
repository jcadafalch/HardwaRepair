package cat.copernic.HardwaRepair.Controller.Producte;

import cat.copernic.HardwaRepair.Model.LiniaReparacio;
import cat.copernic.HardwaRepair.Model.Producte;
import cat.copernic.HardwaRepair.Utils.IsAdministrator;
import cat.copernic.HardwaRepair.serveis.Categoria.CategoriaServiceInterface;
import cat.copernic.HardwaRepair.serveis.LiniaReparacio.LiniaReparacioServiceInterface;
import cat.copernic.HardwaRepair.serveis.Producte.ProducteServiceInterface;
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

/**
 *
 * @author jcadafalch
 */
@Controller
@Slf4j
public class ControladorProducte {
    @Autowired
    private ProducteServiceInterface producteService;

    @Autowired
    private CategoriaServiceInterface categoriaService;

    @Autowired
    private UsuariServiceInterface usuariService;


    @GetMapping("/llistarProductes")
    public String llistarProductes(Model model){{
        try{
            //Passem el llistat de categories a la vista
            model.addAttribute("categories", categoriaService.llistarCategoria());

            //Passem el llistat de productes a la vista
            model.addAttribute("productes", producteService.llistarProductes());
        }catch (NullPointerException e){
            //Si no hi ha categories o productes, mostrem un missatge d'error
            System.out.println("No hi ha categories");
            System.out.println("Error == " + e.getMessage());
        }
        return "llistarProductes";
    }}
    
    @GetMapping("/crearProducte")
    public String crearFormulariProducte(Producte producte, Model model){

        try{
            //Passem el llistat de categories a la vista
            model.addAttribute("categories", categoriaService.llistarCategoria());
            System.out.println("Categories == " + categoriaService.llistarCategoria());
        }catch (NullPointerException e){
            //Si no hi ha categories, mostrem un missatge d'error
            System.out.println("No hi ha categories");
            System.out.println("Error == " + e.getMessage());
        }
        return "crearProducte";
    }
    
    @PostMapping("/guardarProducteCrear")
    public String guardarProducteCrear(@Valid Producte producte, Errors errors, Model model){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de crear producte
            log.info("S'ha produït un error'");
            model.addAttribute("categories", categoriaService.llistarCategoria());
            return "crearProducte";
        }
        //Guardem el producte
        producteService.afegirProducte(producte);
        return "redirect:/llistarProductes";
    }

    @GetMapping("/editarProducte/{idProducte}")
    public String editarProducte(Producte producte, Model model, @AuthenticationPrincipal User username){
        producte = producteService.cercarProducte(producte);

        //Passem el producte a la vista
        model.addAttribute("producte", producte);

        //Passem el llistat de categories a la vista
        model.addAttribute("categories", categoriaService.llistarCategoria());

        //Passem a la vista si l'usuari és administrador
        model.addAttribute("isAdministrator", IsAdministrator.isAdministrator(username.getUsername(), usuariService));
        return "detallsProducte";
    }

    @PostMapping("/guardarProducteDetalls")
    public String guardarProducteDetalls(@Valid Producte producte, Errors errors, Model model, @AuthenticationPrincipal User username){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de detalls producte
            log.info("S'ha produït un error'");

            //Passem el llistat de categories a la vista
            model.addAttribute("categories", categoriaService.llistarCategoria());

            //Passem a la vista si l'usuari és administrador
            model.addAttribute("isAdministrator", IsAdministrator.isAdministrator(username.getUsername(), usuariService));
            return "detallsProducte";
        }
        //Actualitzem el producte
        producteService.afegirProducte(producte);
        return "redirect:/llistarProductes";
    }

    @GetMapping("/eliminarProducte/{idProducte}")
    public String eliminarProducte(Producte producte){
        //Eliminem el producte
        producteService.eliminarProducte(producte);

        //Redirigim a la vista de llistar productes
        return "redirect:/llistarProductes";
    }

}
