package com.damMati.PrimerProjecte.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author fta
 */



/*@Entity converteix la classe en una entitat per poder treballar amb els seus objectes
 *com entitats de la base de dades
*/

/*@Table avisa al sistema que la classe Gos és una entitat de la taula gos per evitar problemes
 *al ser el nom de la classe Gos i el de la taula gos. Això ens donarà problemes sobretot
 *en els S.O. Linux i MAC
*/

/*Implementem la interfície Serializable perque els objectes de gos es puguin guardar
 *com un objecte en la base de dades.
*/

@Data
@Entity
@Table(name="gos")
public class Gos implements Serializable{
    
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID=1L;

    @Id //Indica al sistema que l'atribut idgos és la clau primària de la BBDD
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Indica al sistema com generarem l'id
    private long idgos;
    private String nom;
    private String sexe;
    private int edat;
}
