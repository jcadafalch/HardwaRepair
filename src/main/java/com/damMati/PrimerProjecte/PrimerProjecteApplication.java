package com.damMati.PrimerProjecte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* - Totes les classes que creem, han de portar una anotació que fa referència a una classe
 *   predefinida de Spring. D'aquesta manera el sistema les reconeix com a classes de Spring.
 *
 * - Spring és un contenidor de classes anomenades bins.
 *
 * - Qualsevol classe s'ha de trobar dins el paquet generat en el directori SourcePackages, ja que
 *   és aquí on el sistema va a cercar les classes de l'aplicació, si estan fora d'aquest paquet,
 *   no les reconeix com a classes de l'aplicació.
*/

 //Anotació que fa referència a les classes necessària per executar la nostra aplicació Spring
@SpringBootApplication
public class PrimerProjecteApplication {

	public static void main(String[] args) {
                
                /*El mètode run, és l'encarregat d'executar l'aplicació a la que pertany la classe que passem com a 
                 *primer paràmetre i que ha de contenir el mètode main.
                 *Si l'execució necessita arguments, els passarem com a segon paràmetre.
                */
		SpringApplication.run(PrimerProjecteApplication.class, args);
	}

}
