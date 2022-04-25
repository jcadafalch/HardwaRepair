/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.IncidenciaDAO;
import cat.copernic.HardwaRepair.Model.Incidencia;
import cat.copernic.HardwaRepair.Model.LiniaReparacio;
import cat.copernic.HardwaRepair.serveis.EstatServiceInterface;
import cat.copernic.HardwaRepair.serveis.Incidencia.IncidenciaServiceInterface;
import cat.copernic.HardwaRepair.serveis.LiniaReparacio.LiniaReparacioServiceInterface;
import cat.copernic.HardwaRepair.serveis.Producte.ProducteServiceInterface;
import cat.copernic.HardwaRepair.serveis.Tipus_EquipServiceInterface;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import cat.copernic.HardwaRepair.serveis.tipusOperacioServiceInterface;

/**
 *
 * @author marc
 */
@Controller
@Slf4j
public class ControllerIncidencia {

    @Autowired
    private IncidenciaServiceInterface incidenciaService;

    @Autowired
    private tipusOperacioServiceInterface tipusOperacioService;

    @Autowired
    private Tipus_EquipServiceInterface tipusEquipService;

    @Autowired
    private EstatServiceInterface estatService;

    @Autowired
    private IncidenciaDAO incidenciaDao;

    @Autowired
    private LiniaReparacioServiceInterface liniaReparacioService;

    @Autowired
    private ProducteServiceInterface producteService;

    @GetMapping("/crearIncidencia")
    public String crearIncidencia(Incidencia incidencia, Model model) {
        try {

            //Passem el llistat de estat d'equips a la vista
            model.addAttribute("estats", estatService.llistarEstat());

            //Passem el llistat de tipus d'equips a la vista
            model.addAttribute("tipus_equips", tipusEquipService.llistarTipus_Equip());

            //Passem el llistat de tipusOperacions a la vista
            model.addAttribute("tipus_operacions", tipusOperacioService.llistartipusOperacio());

            //Passem el llistat de incidencies a la vista
            model.addAttribute("Incidencies", incidenciaService.llistarIncidencies());
        } catch (NullPointerException e) {
            //Si no hi ha categories, mostrem un missatge d'error
            System.out.println("No hi ha Incidencies");
            System.out.println("Error == " + e.getMessage());
        }

        return "creaIncidencia";
    }

    @GetMapping("/detallsIncidencia")
    public String detallsIncidencia(Model model) {
        log.info("Executant el controlador de Incidencia");

        //definim la variable de l'incidencia
        var incidencies = incidenciaDao.findAll();

        model.addAttribute("incidencies", incidencies);

        return "detallsIncidencia";

    }

//    @GetMapping("/crearIncidencia")
//    public String crearIncidencia(Model model) {
//        log.info("Executant el controlador de Incidencia");
//        
//        //definim la variable de l'incidencia
//        var incidencies = incidenciaDao.findAll();
//        
//        model.addAttribute("incidencies", incidencies);
//
//        return "creaIncidencia"; 
//        
//    }
//    
//  
    @GetMapping("/llistatIncidencies")
    public String llistarIncidencies(Model model) {
        {
            try {

                //Passem el llistat de tipus_equips a la vista
                model.addAttribute("tipus_equips", tipusEquipService.llistarTipus_Equip());

                //Passem el llistat de tipus_operacions a la vista
                model.addAttribute("tipus_operacions", tipusOperacioService.llistartipusOperacio());

                //Passem el llistat de incidencies a la vista
                model.addAttribute("incidencies", incidenciaService.llistarIncidencies());

            } catch (NullPointerException e) {
                System.out.println("No hi ha Incidencies");
                System.out.println("Error == " + e.getMessage());
            }
            return "llistatIncidencies";
        }
    }

    @PostMapping("/guardarIncidenciaCrear")
    public String guardarIncidenciaCrear(@Valid Incidencia incidencia, Errors errors) {
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de crear incidencia
            log.info("S'ha produït un error'");
            return "/creaIncidencia";
        }
        //Guardem el producte
        incidenciaService.afegirIncidencia(incidencia);
        return "redirect:/llistatIncidencies";
    }

    @GetMapping("/editarIncidencia/{id_incidencia}")
    public String editarIncidencia(Incidencia incidencia, Model model) {
        incidencia = incidenciaService.cercarIncidencia(incidencia);

        //Passem el llistat de estat d'equips a la vista
        model.addAttribute("estats", estatService.llistarEstat());

        //Passem el llistat de tipus d'equips a la vista
        model.addAttribute("tipus_equips", tipusEquipService.llistarTipus_Equip());

        //Passem el llistat de tipusOperacions a la vista
        model.addAttribute("tipus_operacions", tipusOperacioService.llistartipusOperacio());

        //Passem la incidencia a la vista
        model.addAttribute("incidencia", incidencia);

        //Retornem el formulari de detalls
        return "/detallsIncidencia";
    }

    @PostMapping("/guardarIncidenciaDetalls")
    public String guardarIncidenciaDetalls(@Valid Incidencia incidencia, Errors errors) {

        if (errors.hasErrors()) {

            //Si hi ha errors, tornem a la vista de detalls de l'incidencia
            log.info("S'ha produït un error'");
            return "";
        }

        //Actualitzem el producte
        incidenciaService.afegirIncidencia(incidencia);
        return "redirect:/llistatIncidencies";
    }

    @GetMapping("/eliminarIncidencia/{id_incidencia}")
    public String eliminarIncidencia(Incidencia incidencia) {
        //Eliminem el producte
        incidenciaService.eliminarIncidencia(incidencia);

        //Redirigim a la vista de llistar productes
        return "redirect:/llistatIncidencies";
    }

    @GetMapping("/liniaReparacio/{id_incidencia}")
    public String liniaReparacio(Incidencia incidencia,Model model,LiniaReparacio liniareparacio, @AuthenticationPrincipal User username){
        try {
            //Passem el llistat de productes a la vista
            model.addAttribute("productes", producteService.llistarProductes());

            //Passem la linia de reparacio a la vista
            model.addAttribute("liniareparacio", liniareparacio);

            //Passem a la vista el nom de l'usuari en cas que no estigui autenticat ho indiquem
            if(username == null){
                model.addAttribute("username", " Usuari no autenticat");
            }else{
                model.addAttribute("username", username.getUsername());
            }

            //Passem la incidencia a la vista
            System.out.println(incidencia.getId_incidencia());
            model.addAttribute("incidencia", incidenciaService.cercarIncidencia(incidencia));

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
        return "redirect:/llistarProductes";
    }






}
