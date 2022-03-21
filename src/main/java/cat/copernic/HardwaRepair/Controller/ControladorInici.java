package cat.copernic.HardwaRepair.Controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cat.copernic.HardwaRepair.Model.Usuari;
import cat.copernic.HardwaRepair.serveis.UsuariServiceInterface;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jcadafalch
 */
@Controller
@Slf4j
public class ControladorInici {
    
   // @Autowired

    //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlado
    /*Mitjançant aquest atribut de tipus interface, es cridaran els mètodes implementats en la classe GosService,
     *ja que l'objecte de tipus interface va a cercar una classe que implementi la interface, en el nostre cas, 
     *GosService.
     */

    /*Farem que aquest mètode retorni la pàgina inici penjant de de l'arrel de l'aplicacó,
     *passant a ser la pàgina inicial de l'aplicació, la que es mostrarà al escriure localhost:8080
     */
    
    //private UsuariServiceInterface usuaris;
    
    
    /*@AuthenticationPrincipal retorna l'usuari autenticat actualment com un objecte User de Spring security*/
    @GetMapping("/inici") //Arrel de l'aplicació localhost:8080
    public String iniciGet(Model model) {
        return "inici";
    }
    
    @PostMapping("/inici") //Arrel de l'aplicació localhost:8080
    public String inici(Model model) {
        return "inici";
    }

}