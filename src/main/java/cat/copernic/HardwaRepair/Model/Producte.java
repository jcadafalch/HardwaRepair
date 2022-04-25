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
 * @author jcadafalch
 */
@Data
@Entity
@Table(name = "producte")
public class Producte implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducte;

    @NotEmpty
    private String nom;

    @NotNull
    private Double preuCompra;

    @NotNull
    private Double preuVenda;

    @NotEmpty
    private String marca;

    private long categoriaId;

}
