package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Foyer;

public interface IFoyerRepository extends CrudRepository<Foyer,Long> {

    Foyer findByNomFoyer(String nomFoyer);


}
