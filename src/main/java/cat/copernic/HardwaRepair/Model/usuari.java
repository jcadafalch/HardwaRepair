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
import lombok.Data;
/**
 *
 * @author lktol
 */

@Data
@Entity
@Table(name="usuari")
public class usuari implements Serializable{
    
    private static final long serialVersionUID=2L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private String dni;
    private String nom;
    private String cognoms;
    private String telefon;
    private String adreca;
    private String codiPostal;
    private String email;
    private String contrasenya;
    private boolean isAdministrador;
    
}
