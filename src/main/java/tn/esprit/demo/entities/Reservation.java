package tn.esprit.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Reservation implements Serializable
{
    @Id
    private long idReservation;
    private Date anneeUniversitaire;
    private String numReservation ;
    @Temporal(TemporalType.DATE)
    private LocalDate debutanneeUniversitaire;
    @Temporal(TemporalType.DATE)
    private LocalDate finanneeUniversitaire;
    private Boolean estValide ;

    @JsonIgnore
    @ManyToOne
    private Chambre chamber;
    @JsonIgnore
    @ManyToMany
    private Set<Etudiant> etudiants;
}