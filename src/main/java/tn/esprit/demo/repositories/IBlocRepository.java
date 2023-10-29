package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.entities.Chambre;

public interface IBlocRepository extends CrudRepository<Bloc,Long> {
}
