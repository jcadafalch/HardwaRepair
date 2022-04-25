<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/tipusOperacio.java
========
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java
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

<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/tipusOperacio.java

/**
 *
 * @author marc
 */

@Data
@Entity
@Table(name="tipus_operacio")
public class tipusOperacio implements Serializable{
========
>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java

        /**
         *
         * @author lktol
         */
        @Data
        @Entity
        @Table(name="categoria")
        public class Categoria implements Serializable{

<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/tipusOperacio.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipus_operacio;
========
            private static final long serialVersionUID=1L;
>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long idCategoria;

            @NotEmpty
            private String nom;

<<<<<<<< HEAD:src/main/java/cat/copernic/HardwaRepair/Model/tipusOperacio.java
}
========

        }
>>>>>>>> lucas:src/main/java/cat/copernic/HardwaRepair/Model/categoria.java

