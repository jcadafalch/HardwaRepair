package cat.copernic.HardwaRepair.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


/**
 *
 * @author jcadafalch
 */
@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    
    private static final long serialVersionUID=2L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private String idCategoria;
    
    @NotEmpty(message="No has introduït el nom")
    private String nom;
  
}

