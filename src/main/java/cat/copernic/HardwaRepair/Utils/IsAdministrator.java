package cat.copernic.HardwaRepair.Utils;

import cat.copernic.HardwaRepair.Model.Usuari;
import cat.copernic.HardwaRepair.serveis.UsuariServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
            List<Usuari> userList = usuariService.llistarUsuari();
            System.out.println(userList);

            for (Usuari u : userList) {
                if (u.getUsername().equals(username)) {
                    isAdmin = u.getIsAdministrador();
                    System.out.println("Inside for isAdmin: " + isAdmin);
                }
            }


        }catch (NullPointerException e){
            System.out.println("No s'ha trobat l'usuari");
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("isAdmin: "+isAdmin);
        return isAdmin;
    }

}
