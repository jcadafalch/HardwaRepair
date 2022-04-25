/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.ClientDAO;
import cat.copernic.HardwaRepair.Model.Client;
import cat.copernic.HardwaRepair.serveis.ClientServiceInterface;
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
public class ControllerClient {
    
   @Autowired
    private ClientServiceInterface clientService;
    
    @Autowired
    private ClientDAO equipDAO; 

    @GetMapping("/creaClient")
    public String crearFormulariClient(Client client, Model model) {
        try{
            //Passem el llistat de clients a la vista
            model.addAttribute("clients", clientService.llistarClients());
        }catch (NullPointerException e){
            //Si no hi ha categories, mostrem un missatge d'error
            System.out.println("No hi ha clients");
            System.out.println("Error == " + e.getMessage());
        }
        
        return "creaClient"; 
    }
    

    
 @PostMapping("/guardarClientCrear")
    public String guardarClientCrear(@Valid Client client, Errors errors){
        if (errors.hasErrors()) {
            //Si hi ha errors, tornem a la vista de crear client
            log.info("S'ha produït un error'");
            return "llistatIncidencies";
        }
        //Guardem el producte
        clientService.afegirClient(client);
        return "redirect:/crearIncidencia";
    }
    
    
    
    @GetMapping("/editarClient/{dni}")
    public String editarClient(Client client, Model model){
        client = clientService.cercarClient(client);

        //Passem el producte a la vista
        model.addAttribute("client", client);

        //Passem el llistat de categories a la vista
        
        return "";
    }
    
    
    @PostMapping("/guardarClientDetalls")
    public String guardarClientDetalls(@Valid Client client, Errors errors){
        
        if (errors.hasErrors()) {
            
            //Si hi ha errors, tornem a la vista de detalls del client
            log.info("S'ha produït un error'");
            return "";
        }
        
        //Actualitzem el producte
        clientService.afegirClient(client);
        return "redirect:/";
    }
    
    
 
    
    @GetMapping("/eliminarClient/{dni}")
    public String eliminarClient(Client client){
        //Eliminem el producte
        clientService.eliminarClient(client);

        //Redirigim a la vista de llistar productes
        return "redirect:/";
    }
}
