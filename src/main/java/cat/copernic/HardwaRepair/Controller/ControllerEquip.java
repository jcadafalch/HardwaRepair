/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;


import cat.copernic.HardwaRepair.DAO.EquipDAO;
import cat.copernic.HardwaRepair.Model.Equip;
import cat.copernic.HardwaRepair.serveis.EquipService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private EquipDAO equipDAO; 

    @GetMapping("/creaEquip")
    public String inici(Model model) {
        log.info("Executant el controlador de Equips");
        
        //definim la variable equips
        var equips = equipDAO.findAll();
        
        model.addAttribute("equips", equips);

        return "creaEquip"; 
    }
    
//    @GetMapping("/formulariEquips")
//    public String crearFormulariEquip(Equip equip, Model model){
//
//        try{
//            var equips = EquipService.llistarEquips();
//            System.out.println(equips);
//            model.addAttribute("equips", equips);
//        }catch (NullPointerException e){
//            System.out.println("No hi ha categories");
//            System.out.println("Error == " + e.getMessage());
//        }
//
//        return "formulariProducte";
//    }
//    
//    @PostMapping("/guardarProducte")
//    public String guardarProducte(@Valid Producte producte, Errors errors){
//        if (errors.hasErrors()) {
//            log.info("S'ha produït un error'");
//            return "formulariProducte";
//        }
//        
//        producteService.afegirProducte(producte);
//        return "redirect:/llistarProductes";
//    }


    
    
    
    
    
    
}
