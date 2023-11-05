package tn.esprit.demo.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Reservation;
import tn.esprit.demo.repositories.IBlocRepository;
import tn.esprit.demo.repositories.IChambreRepository;
import tn.esprit.demo.repositories.IEtudiantRepository;
import tn.esprit.demo.repositories.IReservationRepository;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ReservationServicesimpl implements IReservationServices {

    IReservationRepository reservationRepo;
    IChambreRepository chambreRepository;
    IEtudiantRepository etudiantRepository;
    IBlocRepository iblocRepository;

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void supprimerReservation(Long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(Long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepo.findAll();
    }
    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        List<Reservation> reservation =  reservationRepo.findByAnneeUniversitaireBetween(debutAnnee, finAnnee);
        return reservation.size();
    }

    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, Long cin) {

        Reservation resrvation = reservationRepo.findById(res.getIdReservation()).orElse(null);
        resrvation.setChamber(chambreRepository.findById(numChambre).orElse(null));
        resrvation.getEtudiants().add(etudiantRepository.findEtudiantByCin(cin));
        return resrvation;

    }


}
