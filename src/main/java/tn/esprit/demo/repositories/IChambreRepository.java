package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.Reservation;
import tn.esprit.demo.entities.TypeChambre;

import java.util.List;

public interface IChambreRepository  extends CrudRepository<Chambre,Long> {

    List<Chambre> findByTypeCAndBlocchambreAndReservations(TypeChambre type, Bloc bloc, Reservation reservation);
    Chambre findChambreByReservations(Reservation reservation);
    List<Chambre> findByBlocchambreAndTypeC(Bloc bloc, TypeChambre type);
    @Query("SELECT c FROM Chambre c WHERE c.blocchambre = :bloc AND c.typeC = :type")
    List<Chambre> findByBlocAndTypeChambre(@Param("bloc") Bloc bloc, @Param("type") TypeChambre type);
}
