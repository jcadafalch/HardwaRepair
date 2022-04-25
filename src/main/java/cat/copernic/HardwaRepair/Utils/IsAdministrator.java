package cat.copernic.HardwaRepair.Utils;

import cat.copernic.HardwaRepair.Model.Usuari;
import cat.copernic.HardwaRepair.serveis.UsuariServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import java.util.List;

/**
 *
 * @author jcadafalch
 */

@Controller
@Slf4j
public class IsAdministrator {

    public static boolean isAdministrator(String username, UsuariServiceInterface usuariService) {
        boolean isAdmin = false;
        try{
            //Llistem tots els usuaris
            List<Usuari> userList = usuariService.llistarUsuari();
            System.out.println(userList);

            //Recorrem la llista de usuaris
            for (Usuari u : userList) {
                if (u.getUsername().equals(username)) {
                    //Si el username coincideix amb el username de l'usuari que estem mirant
                    isAdmin = u.getIsAdministrador();
                    System.out.println("Inside for isAdmin: " + isAdmin);
                }
            }
        }catch (NullPointerException e){
            //Si no hi ha usuaris
            System.out.println("No s'ha trobat l'usuari");
            System.out.println("Error: "+e.getMessage());
        }
        //Retornem si l'usuari es administrador o no
        return isAdmin;
    }
}
