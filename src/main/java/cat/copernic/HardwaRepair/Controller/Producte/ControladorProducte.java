package cat.copernic.HardwaRepair.Controller.Producte;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.LiniaReparacio;
import cat.copernic.HardwaRepair.Model.Producte;
import cat.copernic.HardwaRepair.serveis.CategoriaServiceInterface;
import cat.copernic.HardwaRepair.serveis.LiniaReparacioServiceInterface;
import cat.copernic.HardwaRepair.serveis.ProducteServiceInterface;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        }catch (NullPointerException e){
            //Si no hi ha categories, mostrem un missatge d'error
            System.out.println("No hi ha categories");
            System.out.println("Error == " + e.getMessage());
        }
        return "crearProducte";
    }
    
    @PostMapping("/guardarProducteCrear")
    public String guardarProducteCrear(@Valid Producte producte, Errors errors){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de crear producte
            log.info("S'ha produït un error'");
            return "crearProducte";
        }
        //Guardem el producte
        producteService.afegirProducte(producte);
        return "redirect:/llistarProductes";
    }

    @GetMapping("/editarProducte/{idProducte}")
    public String editarProducte(Producte producte, Model model){
        producte = producteService.cercarProducte(producte);

        //Passem el producte a la vista
        model.addAttribute("producte", producte);

        //Passem el llistat de categories a la vista
        model.addAttribute("categories", categoriaService.llistarCategoria());
        return "detallsProducte";
    }

    @PostMapping("/guardarProducteDetalls")
    public String guardarProducteDetalls(@Valid Producte producte, Errors errors){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de detalls producte
            log.info("S'ha produït un error'");
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

    @Autowired
    private LiniaReparacioServiceInterface liniaService;

    @GetMapping("/liniaReparacio")
    public String liniaReparacio(Model model){
        try {
            //Passem el llistat de productes a la vista
            model.addAttribute("productes", producteService.llistarProductes());
        }catch (NullPointerException e){
            //Si no hi ha productes, mostrem un missatge d'error
            System.out.println("No hi ha productes");
            System.out.println("Error == " + e.getMessage());
        }

        return "liniaReparacio";
    }

    @PostMapping("/guardarLiniaReparacio")
    public String guardarLiniaReparacio(@Valid LiniaReparacio liniaReparacio, Errors errors){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de linia reparació
            log.info("S'ha produït un error'");
            return "liniaReparacio";
        }
        //Guardem la linia reparació
        liniaService.afegirLiniaReparacio(liniaReparacio);
        //return "redirect:/liniaReparacio";
        return "redirect:/llistarProductes";
    }

}
