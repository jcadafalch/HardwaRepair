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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


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
  //@GeneratedValue(strategy=GenerationType.IDENTITY)   
    @NotNull
    private long id_incidencia;
   
    @NotNull
    private double preu_total;
    
    @NotNull
    private long estat_id;
 
    @NotEmpty
    private String reparador;
   
    @NotNull
    private long tipus_operacio_id;
   
    @NotEmpty
    private String cliente_id;
   
    
    private boolean solicitud_pressupost;
   
    
    private boolean garantia;
   
    @NotEmpty
    private String descripcio_averia;
   
    @DateTimeFormat(iso = ISO.DATE)
    private Date data_creacio;
   
    @NotNull
    private long tipus_equip;
   
    @NotEmpty
    private String equip_a_reparar_id;
   
    @NotEmpty
    private String creador;
   
    @DateTimeFormat(iso = ISO.DATE)
    private Date data_resolucio;
   
    @NotEmpty
    private String num_factura_garantia;
 
}
