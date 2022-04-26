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
 * @author marc
 */


//Model que indica el tipus d'equip de la incidencia.


@Data
@Entity
@Table(name="tipusEquip")
public class Tipus_Equip implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipus_equip;

    @NotEmpty
    private String nom;
}

