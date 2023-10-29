package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Chambre;

public interface IChambreRepository  extends CrudRepository<Chambre,Long> {
}
