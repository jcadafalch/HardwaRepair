/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.IncidenciaDAO;
import cat.copernic.HardwaRepair.Model.Incidencia;
import cat.copernic.HardwaRepair.Model.LiniaReparacio;
import cat.copernic.HardwaRepair.serveis.Incidencia.IncidenciaServiceInterface;
import cat.copernic.HardwaRepair.serveis.LiniaReparacio.LiniaReparacioServiceInterface;
import cat.copernic.HardwaRepair.serveis.Producte.ProducteServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 * @author marc
 */


@Controller
@Slf4j
public class ControllerIncidencia {

    @Autowired
    private IncidenciaDAO incidenciaDao;

    @Autowired
    private LiniaReparacioServiceInterface liniaReparacioService;

    @Autowired
    private ProducteServiceInterface producteService;

    @GetMapping("/Incidencies")
    public String inici(Model model) {
        log.info("Executant el controlador de Incidencia");
        
        //definim la variable de l'incidencia
        var incidencies = incidenciaDao.findAll();
        
        model.addAttribute("incidencies", incidencies);

        return "inici"; 
        
    }
//    
//    
    @Autowired
    private IncidenciaServiceInterface incidenciaService;


    @GetMapping("/llistatIncidencies")
    public String llistarProductes(Model model){{
        try{
            model.addAttribute("incidencies", incidenciaService.llistarIncidencies());
        }catch (NullPointerException e){
            System.out.println("No hi ha Incidencies");
            System.out.println("Error == " + e.getMessage());
        }
        return "llistatIncidencies";
    }}

    


    @GetMapping("/liniaReparacio/{id_incidencia}")
    public String liniaReparacio(Incidencia incidencia,Model model){
        try {
            //Passem el llistat de productes a la vista
            model.addAttribute("productes", producteService.llistarProductes());

            System.out.println("Productes == " + producteService.llistarProductes());

            //Passem la incidencia a la vista
            model.addAttribute("incidencia", incidencia);
            System.out.println("Incidencia == " + incidencia);

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
        liniaReparacioService.afegirLiniaReparacio(liniaReparacio);
        //return "redirect:/liniaReparacio";
        return "redirect:/llistarProductes";
    }





    /*@GetMapping("/llistatIncidencies")
    public String llistarProductes(Model model){{
        try{
            model.addAttribute("incidencies", incidenciaService.llistarIncidencies());
            System.out.println(incidenciaService.llistarIncidencies());
        }catch (NullPointerException e){
            System.out.println("No hi ha Incidencies");
            System.out.println("Error == " + e.getMessage());
        }
        return "llistatIncidencies";
    }}*/

}
