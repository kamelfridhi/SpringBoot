package tn.esprit.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Bloc implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloc;
    private String nomBloc;
    private Long capaciteBloc;
    @JsonIgnore
    @ManyToOne(cascade ={CascadeType.PERSIST})
    private Foyer foyer;
    @JsonIgnore
    @OneToMany(mappedBy = "blocchambre", fetch =FetchType.EAGER,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Chambre> chambres; // max Many taaml Set


}