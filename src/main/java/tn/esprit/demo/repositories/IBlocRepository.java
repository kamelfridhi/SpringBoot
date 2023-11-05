package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.Foyer;

import java.util.List;

public interface IBlocRepository extends CrudRepository<Bloc,Long> {
    Bloc findByNomBloc(String nombloc);
    List<Bloc> findByFoyer(Foyer foyer);
}
