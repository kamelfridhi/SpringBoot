package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Reservation;

public interface IReservationRepository extends CrudRepository<Reservation,Long> {
}
