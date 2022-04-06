package cat.copernic.HardwaRepair.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author jcadafalch
 */
@Data
@Entity
@Table(name = "linia_reparacio")
public class LiniaReparacio implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private long idLiniaReparacio;

    @NotNull
    private long incidenciaId;

    @NotNull
    private long producteId;

    @NotNull
    private int quantitat;

}

