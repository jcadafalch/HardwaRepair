
package cat.copernic.HardwaRepair.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;


/**
 *
 * @author marc
 */

@Data
@Entity
@Table(name="cliente")
public class Client implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @NotEmpty
    private String dni;
    
    @NotEmpty
    private String nom;
    
    @NotEmpty
    private String cognoms;
    
    @NotEmpty
    private String adreca;
    
    @NotNull
    private int telefon;
    
    @NotNull
    private int codi_postal;
    
}
