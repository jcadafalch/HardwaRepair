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
         * @author lktol
         */
        @Data
        @Entity
        @Table(name="categoria")
        public class Categoria implements Serializable{

            private static final long serialVersionUID=1L;

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long idCategoria;

            @NotEmpty
            private String nom;


        }


