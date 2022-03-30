
package cat.copernic.HardwaRepair.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="client")
public class Client implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty
    private String idclient;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String cognom;
    @NotEmpty
    private String adreça;
    @NotNull
    private int telefon;
    @NotNull
    private int codipostal;
    
}
