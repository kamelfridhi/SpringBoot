package tn.esprit.demo.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Reservation implements Serializable
{
    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide ;


    @ManyToMany
    private Set<Etudiant> etudiants;
}