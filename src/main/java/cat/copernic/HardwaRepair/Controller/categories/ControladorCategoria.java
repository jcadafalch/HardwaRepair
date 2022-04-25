
package cat.copernic.HardwaRepair.Controller.categories;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.Categoria;
import cat.copernic.HardwaRepair.serveis.CategoriaServiceInterface;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Lucas Tolón Pacheco
 */

@Controller
@Slf4j
public class ControladorCategoria {
    
    @Autowired
    private CategoriaServiceInterface categoriaService;
    @Autowired
    private CategoriaDAO categoriaDAO;
    
    @GetMapping("/llistarCategories")
    public String llistarCategories(Model model){{
        try{
            model.addAttribute("categories", categoriaService.llistarCategoria());
        }catch (NullPointerException e){
            System.out.println("No hi ha categories");
            System.out.println("Error == " + e.getMessage());
        }
        return "llistarCategories";
    }}

    @GetMapping("/formulariCategoria")
    public String crearFormulariCategoria(Categoria categoria, Model model){
        model.addAttribute("founded", false);
        return "formulariCategoria";
    }
    
    @PostMapping("/guardarCategoria")
    public String guardarCategoria(@Valid Categoria categoria, Errors errors, RedirectAttributes redirectAttrs){
        if (errors.hasErrors()) {
            log.info("S'ha produït un error'");
            return "formulariCategoria";
        }
        
        if(categoriaDAO.findByNom(categoria.getNom()) != null){
            redirectAttrs
            .addFlashAttribute("mensaje", "No pots crear dues categories amb el mateix nom")
            .addFlashAttribute("clase", "error");
            return "redirect:/llistarCategories";
        }
        
        categoriaService.afegirCategoria(categoria);
        return "redirect:/llistarCategories";
    }

    @GetMapping("/editarCategoria/{idCategoria}")
    public String editarCategoria(Categoria categoria, Model model){
        System.out.println("Categoria a editar == " + categoria);
        log.info(String.valueOf(categoria.getIdCategoria()));

        categoria = categoriaService.cercarCategoria(categoria);
        System.out.println("Categoria a editar == " + categoria);
        model.addAttribute("categoria", categoria);
        model.addAttribute("founded", true);
        return "formulariCategoria";
    }
    
    @GetMapping("/eliminarCategoria/{idCategoria}")
    public String eliminarCategoria(Categoria categoria){
        //Eliminem la categoria
        categoriaService.eliminarCategoria(categoria);

        //Redirigim a la vista de llistar categories
        return "redirect:/llistarCategories";
    }


    
    @GetMapping("/categoriaController")
    public String inici(Model model) {
        log.info("Executant el controlador de Categoria");
        
        var categories = categoriaDAO.findAll();
        
        model.addAttribute("categories", categories);
        
        return "categoriaController";
    }
}

