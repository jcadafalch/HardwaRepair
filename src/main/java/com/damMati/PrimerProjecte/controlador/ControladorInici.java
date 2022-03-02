package com.damMati.PrimerProjecte.controlador;

import com.damMati.PrimerProjecte.model.Gos;
import com.damMati.PrimerProjecte.serveis.GosServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author fta
 */
@Controller
@Slf4j
public class ControladorInici {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlado
    /*Mitjançant aquest atribut de tipus interface, es cridaran els mètodes implementats en la classe GosService,
     *ja que l'objecte de tipus interface va a cercar una classe que implementi la interface, en el nostre cas, 
     *GosService.
     */
    private GosServiceInterface gosService;

    /*Farem que aquest mètode retorni la pàgina inici penjant de de l'arrel de l'aplicacó,
     *passant a ser la pàgina inicial de l'aplicació, la que es mostrarà al escriure localhost:8080
     */
    @GetMapping("/") //Arrel de l'aplicació localhost:8080
    public String inici(Model model) {
        log.info("Executant el controlador Spring MVC");

        /*Definim variable gossos on emmagatzemarem els gossos de la taula gos obtinguts mitjançant el mètode 
         *llistarGossos definit en la interface GosServiceInterface i implementat en la classe GosService
         */
        var gossos = gosService.llistarGossos();

        model.addAttribute("gossos", gossos);

        return "inici"; //Retorna la pàgina inici
    }

    /*Definim el mètode per mostrar la pàgina amb el forumlari de les dades del gos passat com a paràmetre.
     *Aquest gos, si no èxistei, es crearà de manera automàtica en el moment que executem aquest mètode amb els
     *atributs buits (recordem que el constructor construeix un objecte buit).
     *
     */
    @GetMapping("/formulariGos") //URL a la pàgina amb el formulari de les dades del gos
    public String crearFormulariGos(Gos gos) {

        return "formulariGos"; //Retorna la pàgina on es mostrarà el formulari de les dades dels gos
    }

    /*Definim el mètode per assignar els valors introduïts en el formulari, a l'objecte gos
     *passat com a paràmetre en el mètode dadesGos. Això ho fem mitjançant l'anotació @PostMapping,
     *ja que el mètode que fem servir per enviar les dades és el post. Com a paràmetre hem de passar
     *el valor de l'action del formulari, d'aquesta manera el sistema identifica el mètode al qual ha
     *d'enviar les dades introduïdes mitjançant el formulari.
     *
     *A part d'assignar les dades a gos mitjançant @PostMapping, en aquest cas utilitzarem el mètode
     *afegirGos de la classe GosService, per guardar el gos en la base de dades i finalment retornar
     *a la pàgina d'inici.
     */
    @PostMapping("/guardarGos") //action = guardarGos
    public String guardarGos(Gos gos) {

        gosService.afegirGos(gos); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/"; //Retornem a la pàgina inici mitjançant redirect
    }

    /*Definim el mètode que ens retornarà la pàgina formulariGos on se'ns mostraran les dades del gos
     *amb l'idgos de l'URL que li passem a @GetMapping com a paràmetre, ja que en aquest cas el gos 
     *existei.
     *El sistema Spring associa l'idgos passat com a paràmetre en @GetMapping al gos 
     *passat com a paràmetre en el mètode editar i crida automàticament al mètode setIdgos 
     *de la classe Gos per fer aquesta associació, és a dir, el que fa és gos.setIdgos(idgos).
     *IMPORTANT: idgos ha de tenir el mateix nom que l'atribut id de la classe Gos.
     */
    @GetMapping("/editar/{idgos}")
    public String editar(Gos gos, Model model) {

        log.info(String.valueOf(gos.getIdgos())); //Mostra idgos de Gos

        /*Cerquem el gos passat per paràmetre amb l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        gos = gosService.cercarGos(gos);

        model.addAttribute("gos", gos); //Enviem les dades del gos resultant de la cerca a la pàgina formulariGos

        return "formulariGos"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    
    /*Definim el mètode per guardar el gos en la base de dades i finalment retornar
     *a la pàgina d'inici. El gos l'eliminarem mitjançant el mètode eliminarGos de
     *la classe GosService.
     *El sistema per associar l'id del gos a l'objecte gos passat per paràmetre, és el mateix
     *que el del mètode editar.
     *IMPORTANT: idgos ha de tenir el mateix nom que l'atribut id de la classe Gos.
     */
    @GetMapping("/eliminar/{idgos}") 
    public String eliminar(Gos gos) {

        /*Eliminem el gos passat per paràmetre amb l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        gosService.eliminarGos(gos);
        
        return "redirect:/"; //Retornem a la pàgina inici mitjançant redirect
    }
    
    /*Mètode eliminar utilitzant query paràmetres. Com en el mètode editar, @GetMaping
     *crida automàticament al mètode setIdgos de la classe Gos per assignar-li l'idGos
     *que hem rebut mitjançant el paràmetre de consulta a l'objecte Gos que passem com a
     *paràmetre del mètode eliminar.
     * 

    @GetMapping("/eliminar") //URL eliminar + paràmetre de consulta inclós en el mateix URL
    public String eliminar(Gos gos) {    */

        /*Eliminem el gos passat per paràmetre amb l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.
        gosService.eliminarGos(gos);
        
        return "redirect:/"; //Retornem a la pàgina inici mitjançant redirect
    }*/

}
