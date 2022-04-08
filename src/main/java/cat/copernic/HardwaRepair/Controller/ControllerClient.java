/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller;

import cat.copernic.HardwaRepair.DAO.ClientDAO;
import cat.copernic.HardwaRepair.serveis.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marc
 */


@Controller
@Slf4j
public class ControllerClient {
    @Autowired
    private ClientDAO clientDao; 

    @GetMapping("/creaClient")
    public String creaClient(Model model) {
        log.info("Executant el controlador de Client");
        
        //definim la variable clients
        var clients = clientDao.findAll();
        
        model.addAttribute("clients", clients);

        return "creaClient"; 
    }
    
    
//    
//    @GetMapping("/formulariClient")
//    public String crearFormulariClient(Client client, Model model) {
//
//        try {
//            var categories = ClientService.llistarCategoria();
//            System.out.println(categories);
//            model.addAttribute("categories", categories);
//        } catch (NullPointerException e) {
//            System.out.println("No hi ha categories");
//            System.out.println("Error == " + e.getMessage());
//        }
//
//        return "formulariClient";
//    }
//
//    @PostMapping("/guardarClient")
//    public String guardarClient(@Valid Client client, Errors errors) {
//        if (errors.hasErrors()) {
//            log.info("S'ha produït un error'");
//            return "formulariClient";
//        }
//
//        ClientService.afegirClient(client);
//        return "redirect:/llistarClients";
//    }


}
