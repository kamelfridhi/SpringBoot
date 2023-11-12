package tn.esprit.demo.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.Reservation;
import tn.esprit.demo.entities.TypeChambre;
import tn.esprit.demo.repositories.IBlocRepository;
import tn.esprit.demo.repositories.IChambreRepository;
import tn.esprit.demo.repositories.IEtudiantRepository;
import tn.esprit.demo.repositories.IReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
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


    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre ch = chambreRepository.findById(idChambre).orElse(null);
        Etudiant et = etudiantRepository.findEtudiantByCin(cinEtudiant);
        Reservation r = new Reservation();
        r.setNumReservation(ch.getNumeroChambre()+"-"+ch.getBlocchambre().getNomBloc()+"-"+cinEtudiant);
        r.setDebutanneeUniversitaire(LocalDate.parse(LocalDate.now().getYear() + "-09-01"));
        r.setFinanneeUniversitaire(LocalDate.parse((LocalDate.now().getYear() + 1) + "-06-01"));
        r.setEstValide(true);
        int c=ch.getReservations().size();
        if(r.getEtudiants()==null){
            r.setEtudiants(new HashSet<>());
        }
        if(ch.getReservations()==null){
            ch.setReservations(new HashSet<>());
        }
        if(ch.getTypeC()==TypeChambre.SIMPLE && c<1 ){
            r=reservationRepo.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;

        }

        if(ch.getTypeC()==TypeChambre.DOUBLE && c<2 ){
            r=reservationRepo.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;


        }
        if(ch.getTypeC()==TypeChambre.TRIPLE && c<3 ){
            r=reservationRepo.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;

        }

        return null;
    }
    @Transactional
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e =etudiantRepository.findEtudiantByCin(cinEtudiant);
        List<Reservation> r = reservationRepo.findByEtudiants(e);
        for(Reservation re:r) {
            Chambre ch = chambreRepository.findChambreByReservations(re);
            ch.getReservations().remove(re);
            re.getEtudiants().remove(e);
            re.setEstValide(false);
            reservationRepo.save(re);
        }


        return null;
    }




}
