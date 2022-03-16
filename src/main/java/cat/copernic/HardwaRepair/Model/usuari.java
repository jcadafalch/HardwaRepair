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
    
    @NotEmpty(message="No has introduït el nom")
    private String nom;
    
    @NotEmpty(message="No has introduït els cognoms")
    private String cognoms;
    
    @NotEmpty(message="No has introduït el telefon")
    private String telefon;
    
    @NotEmpty(message="No has introduït la adreça")
    private String adreca;
    
    @NotEmpty(message="No has introduït el codi postal")
    private String codiPostal;
    
    @NotEmpty(message="No has introduït el correu")
    private String email;
    
    @NotEmpty(message="No has introduït la contrasenya")
    private String contrasenya;
    
    @NotEmpty(message="Torna a introduir la contrasenya")
    private String contrasenya2;
    
    private boolean isAdministrador;
    
}
