package tn.esprit.demo.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Reservation;
import tn.esprit.demo.services.IReservationServices;

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
}
