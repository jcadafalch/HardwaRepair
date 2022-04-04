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
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author fta
 */

@Data
@Entity
@Table(name="usuari")
public class Usuari implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id //L'atribut idUsuari és la clau primària de la BBDD
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Generació autonumèrica de l'id
    private long idUsuari;
    
    
    @NotEmpty
    private String username;
    
    
    @NotEmpty//Validació perquè l'usuari afegeixi contingut al camp contrasenya
    private String password;
    
    @NotEmpty
    @Size(min = 9, max = 9)
    private String dni;
    
    private String nom;
    
    private String cognoms;
    
    @NotEmpty
    private String telefon;
    
    private String adreca;
    
    @Size(min = 5, max = 5)
    private String codiPostal;
    
    @NotEmpty
    private Boolean isAdministrador;
}
