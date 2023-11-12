package tn.esprit.demo.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Reservation;
import tn.esprit.demo.services.IReservationServices;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("reservation")
@RestController
public class ReservationRestController {

    private final IReservationServices reservationService;

    @GetMapping("/all")
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservations();
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation r){
        return reservationService.ajouterReservation(r);
    }

    @PostMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation r){
        return reservationService.updateReservation(r);
    }

    @DeleteMapping ("/delete/{idReservation}")
    public void deleteReservation(@PathVariable Long idReservation){
        reservationService.supprimerReservation(idReservation);
    }

    @PutMapping("UpdateReservation")
    public Reservation MOdifierBlocs(@RequestBody Reservation r)
    {
        return reservationService.updateReservation(r);
    }
    @PutMapping("ajouterReservationEtAssignerAChambreEtAEtudiant/{numChambre}/{id_etudiant}")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant( @RequestBody Reservation r, @PathVariable long numChambre, @PathVariable long id_etudiant)
    {
        return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(r,numChambre,id_etudiant);
    }
    @GetMapping("getReservationParAnneeUniversitaire/{debutAnnee}/{finAnnee}")
    public long getReservationParAnneeUniversitaire(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debutAnnee,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finAnnee){
        return reservationService.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }

    @PutMapping("ajouterReservation/{idchambre}/{cin_etudiant}")
    public Reservation ajouterReservation(  @PathVariable long idchambre, @PathVariable long cin_etudiant)
    {
        return reservationService.ajouterReservation(idchambre,cin_etudiant);
    }
    @DeleteMapping ("annulerReservation/{cin_etudiant}")
    public Reservation annulerReservation( @PathVariable long cin_etudiant)
    {
        return reservationService.annulerReservation(cin_etudiant);
    }

}
