package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.demo.entities.Foyer;
import tn.esprit.demo.entities.TypeChambre;

import java.util.List;

public interface IFoyerRepository extends CrudRepository<Foyer,Long> {

    Foyer findByNomFoyer(String nomFoyer);
    @Query("select f from Foyer f join f.blocs b join b.chambres ch where ch.typeC = :type")
    List<Foyer> getFoyerByTypeChambre(@Param("type")TypeChambre typeC);


}
