package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.Reservation;
import tn.esprit.demo.entities.TypeChambre;

import java.util.List;

public interface IChambreRepository  extends CrudRepository<Chambre,Long> {

    List<Chambre> findByTypeCAndBlocchambreAndReservations(TypeChambre type, Bloc bloc, Reservation reservation);

}
