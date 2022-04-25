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
<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/Equip.java
import javax.validation.constraints.NotNull;
========
>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java
import lombok.Data;

/**
 *
<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/Equip.java
 * @author marc
========
 * @author lktol
>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java
 */

@Data
@Entity
<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/Equip.java
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
    
========
@Table(name="categoria")
public class Categoria implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @NotEmpty
    private String nom;


>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java
}


