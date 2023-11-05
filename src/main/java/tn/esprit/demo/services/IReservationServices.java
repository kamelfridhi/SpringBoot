package tn.esprit.demo.services;

import tn.esprit.demo.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationServices {
    Reservation ajouterReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    void supprimerReservation(Long idReservation);
    Reservation getReservation(Long idReservation);
    List<Reservation> getAllReservations();
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long
            numChambre, Long cin) ;
    long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee ) ;
}
