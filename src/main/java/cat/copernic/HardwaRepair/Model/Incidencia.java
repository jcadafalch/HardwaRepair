        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Model;

import java.io.Serializable;
import java.util.Date;
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
    private String idIncidencia;
   
    @NotNull
    private double preuTotal;
 
    @NotEmpty
    private String reparador;
   
    @NotEmpty
    private String tipusOperacio;
   
    @NotEmpty
    private String idClient;
   
    @NotEmpty
    private boolean soluGarantia;
   
    @NotEmpty
    private boolean garantia;
   
    @NotEmpty
    private String decripcio;
   
    @NotEmpty
    private Date dataCreacio;
   
    @NotEmpty
    private String tipusEquip;
   
    @NotEmpty
    private String idEquip;
   
    @NotEmpty
    private String idCreador;
   
    @NotEmpty
    private Date dataResolucio;
   
    @NotEmpty
    private String numFactGarantia;
    
    @NotEmpty
    private String productesUtilitzats;
}
