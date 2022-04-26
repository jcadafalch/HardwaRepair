/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;


import cat.copernic.HardwaRepair.DAO.EquipDAO;
import cat.copernic.HardwaRepair.Model.Equip;
import cat.copernic.HardwaRepair.serveis.Equip.EquipServiceInterface;
import cat.copernic.HardwaRepair.serveis.Tipus_EquipServiceInterface;
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
    private Tipus_EquipServiceInterface tipusEquipService;
    
    @Autowired
    private EquipDAO equipDAO;
    
    
    
    
    @GetMapping("/llistarEquips")
    public String llistarEquips(Model model) {
        {
            try {

                //Passem el llistat d'Equips.
                model.addAttribute("equips", equipService.llistarEquips());

            } catch (NullPointerException e) {
                System.out.println("No hi ha Incidencies");
                System.out.println("Error == " + e.getMessage());
            }
            return "llistatEquips";
        }
    }
    
    
    
    

    @GetMapping("/creaEquip")
    public String crearFormulariEquip(Equip equip, Model model) {
        try{
            //Passem el llistat de tipus d'equips a la vista
            model.addAttribute("tipus_equips", tipusEquipService.llistarTipus_Equip());
            //Passem el llistat de categories a la vista
            model.addAttribute("categories", equipService.llistarEquips());
        }catch (NullPointerException e){
            //Si no hi ha equips, mostrem un missatge d'error
            System.out.println("No hi ha equips");
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
        //Guardem el equip
        equipService.afegirEquip(equip);
        return "redirect:/llistatIncidencies";
    }
    
    
    
    @GetMapping("/editarEquip/{num_serie}")
    public String editarEquip(Equip equip, Model model){
        equip = equipService.cercarEquip(equip);

        //Passem el equip a la vista
        model.addAttribute("equip", equip);

        //Passem el llistat de categories a la vista
        
        return "redirect:/llistatIncidencies";
    }
    
    
    @PostMapping("/guardarEquipDetalls")
    public String guardarEquipDetalls(@Valid Equip equip, Errors errors){
        
        if (errors.hasErrors()) {
            
            //Si hi ha errors, tornem a la vista de detalls de l'equip
            log.info("S'ha produït un error'");
            return "detallsProducte";
        }
        
        //Actualitzem el equip
        equipService.afegirEquip(equip);
        return "redirect:/llistatIncidencies";
    }
    
    
 
    
    @GetMapping("/eliminarEquip/{num_serie}")
    public String eliminarEquip(Equip equip){
        //Eliminem el producte
        equipService.eliminarEquip(equip);

        //Redirigim a la vista de llistat Incidencies 
        return "redirect:/llistatIncidencies";
    }
    
    
}
