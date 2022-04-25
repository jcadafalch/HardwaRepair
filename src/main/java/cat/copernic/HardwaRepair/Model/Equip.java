        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "equip")
public class Equip implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @NotEmpty
    private String num_serie;
    
    @NotEmpty
    private String client_id;
    
    @NotEmpty
    private String marca;
    
    @NotEmpty
    private String model;
   
    @NotEmpty
    private String descripcio;
    
    @NotNull
    private int tipus_equip_id;
    
}
