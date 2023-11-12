package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends CrudRepository<Reservation,Long> {
    List<Reservation> findByAnneeUniversitaireBetween(Date debutAnnee, Date finAnnee);
    List<Reservation> findByEtudiants(Etudiant etudiant);
}
