/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Eines;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author jcadafalch
 */
public class EncriptadorContrasenyes {

    public static void main(String[] args) {

        var password = "123456";
        System.out.println("Contrasenya: " + password);
        System.out.println("Contrasenya encriptada: " + encriptarContrasenya(password));
    }

    public static String encriptarContrasenya(String password) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
