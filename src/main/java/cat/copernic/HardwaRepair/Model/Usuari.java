package cat.copernic.HardwaRepair.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Lucas Tolón Pacheco
 */
@Data
@Entity
@Table(name = "usuari")
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //L'atribut idUsuari és la clau primària de la BBDD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generació autonumèrica de l'id
    private long idUsuari;

    @NotEmpty
    private String username;

    private String password;

    private String dni;

    private String nom;

    private String cognoms;

    @NotEmpty
    private String telefon;

    private String adreca;

    @Size(min = 5, max = 5)
    private String codiPostal;

    @NotNull
    private Boolean isAdministrador;

    /*Implementem l'atribut que relacionarà l'usuari amb el rol, tenint en compte que un 
     *usuari pot tenir més d'un rol, per tant serà una col.lecció de tipus list, on guardarem
     *tots els rols de l'usuari.
     */
    @OneToMany //Indica al sistema que la relació entre les taules usuari i rol en aquest cas és d'un a molts.
    @JoinColumn(name = "idUsuari") //Columna de la base de dades que farà de clau forana relacionant les dues taules.
    private List<Rol> rols;
}
