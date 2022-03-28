package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.Model.Producte;
import cat.copernic.HardwaRepair.serveis.CategoriaService;
import cat.copernic.HardwaRepair.serveis.CategoriaServiceInterface;
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
public class ControladorFormulariProducte {
    @Autowired
    
    private ProducteServiceInterface producteService;
    private CategoriaServiceInterface categoriaService;
    
    @GetMapping("/formulariProducte")
    public String crearFormulariProducte(Producte producte, Model model){
        
       //System.out.println(categoriaService.llistarCategories());
       /* var categories = categoriaService.llistarCategories();
        model.addAttribute("categories", categories);
        */
        return "formulariProducte";
    }
    
    @PostMapping("/guardarProducte")
    public String guardarProducte(@Valid Producte producte, Errors errors){
        if (errors.hasErrors()) {
            log.info("S'ha produït un error'");
            return "formulariProducte";
        }
        
        producteService.afegirProducte(producte);
        return "redirect:/llistarProductes";
    }
}
