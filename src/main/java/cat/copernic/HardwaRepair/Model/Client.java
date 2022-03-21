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
 * @author marc
 */
@Data
@Entity
@Table(name="client")
public class Client implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty
    private String idclient;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String cognom;
    @NotEmpty
    private String adreça;
    @NotEmpty
    private int telefon;
    @NotEmpty
    private int codipostal;
    
}
