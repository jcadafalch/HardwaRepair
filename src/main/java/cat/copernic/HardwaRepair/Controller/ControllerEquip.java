/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;


import cat.copernic.HardwaRepair.DAO.EquipDAO;
import cat.copernic.HardwaRepair.Model.Equip;
import cat.copernic.HardwaRepair.serveis.EquipServiceInterface;
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
 * @author marc
 */
@Controller
@Slf4j
public class ControllerEquip {
    
    @Autowired
    private EquipServiceInterface equipService;
    
    @Autowired
    private EquipDAO equipDAO; 

    @GetMapping("/creaEquip")
    public String crearFormulariEquip(Equip equip, Model model) {
        try{
            //Passem el llistat de categories a la vista
            model.addAttribute("categories", equipService.llistarEquips());
        }catch (NullPointerException e){
            //Si no hi ha categories, mostrem un missatge d'error
            System.out.println("No hi ha categories");
            System.out.println("Error == " + e.getMessage());
        }
        
        return "creaEquip"; 
    }
    

    
 @PostMapping("/guardarEquipCrear")
    public String guardarEquipCrear(@Valid Equip equip, Errors errors){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de crear equip
            log.info("S'ha produït un error'");
            return "crearIncidencia";
        }
        //Guardem el producte
        equipService.afegirEquip(equip);
        return "redirect:/llistatIncidencies";
    }
    
    
    
    @GetMapping("/editarEquip/{num_serie}")
    public String editarEquip(Equip equip, Model model){
        equip = equipService.cercarEquip(equip);

        //Passem el producte a la vista
        model.addAttribute("equip", equip);

        //Passem el llistat de categories a la vista
        
        return "";
    }
    
    
    @PostMapping("/guardarEquipDetalls")
    public String guardarEquipDetalls(@Valid Equip equip, Errors errors){
        
        if (errors.hasErrors()) {
            
            //Si hi ha errors, tornem a la vista de detalls de l'equip
            log.info("S'ha produït un error'");
            return "detallsProducte";
        }
        
        //Actualitzem el producte
        equipService.afegirEquip(equip);
        return "redirect:/";
    }
    
    
 
    
    @GetMapping("/eliminarEquip/{num_serie}")
    public String eliminarEquip(Equip equip){
        //Eliminem el producte
        equipService.eliminarEquip(equip);

        //Redirigim a la vista de llistar productes
        return "redirect:/";
    }
    
    
}
