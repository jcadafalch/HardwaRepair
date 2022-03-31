package cat.copernic.HardwaRepair.Controller.Producte;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.Producte;
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
public class ControladorProducte {
    @Autowired
    private ProducteServiceInterface producteService;

    @Autowired
    private CategoriaServiceInterface categoriaService;


    @GetMapping("/llistarProductes")
    public String llistarProductes(Model model){{
        model.addAttribute("productes", producteService.llistarProductes());
        return "llistarProductes";
    }}
    
    @GetMapping("/formulariProducte")
    public String crearFormulariProducte(Producte producte, Model model){

        try{
            var categories = categoriaService.llistarCategoria();
            System.out.println(categories);
            model.addAttribute("categories", categories);
        }catch (NullPointerException e){
            System.out.println("No hi ha categories");
            System.out.println("Error == " + e.getMessage());
        }



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