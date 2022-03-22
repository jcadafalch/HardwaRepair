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
 * @author Lucas Tolón Pacheco
 */

@Data
@Entity
@Table(name="categoria")
public class categoria implements Serializable{
    
    private static final long serialVersionUID=2L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private String id;
    
    @NotEmpty(message="No has introduït el nom")
    private String nom;
  
}