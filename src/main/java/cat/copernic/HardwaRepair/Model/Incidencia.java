        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name="incidencia")
public class Incidencia implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)   
    @NotEmpty
    private String id_incidencia;
   
    @NotNull
    private double preu_total;
    
    @NotNull
    private double estat_id;
 
    @NotEmpty
    private String reparador;
   
    @NotEmpty
    private String tipus_operacio_id;
   
    @NotEmpty
    private String cliente_id;
   
    @NotEmpty
    private boolean solicitud_pressupost;
   
    @NotEmpty
    private boolean garantia;
   
    @NotEmpty
    private String descripcio_averia;
   
    @NotEmpty
    private Date data_creacio;
   
    @NotEmpty
    private String tipus_equip;
   
    @NotEmpty
    private String equip_a_reparar_id;
   
    @NotEmpty
    private String creador;
   
    @NotEmpty
    private Date data_resolucio;
   
    @NotEmpty
    private String num_factura_garantia;
 
}
