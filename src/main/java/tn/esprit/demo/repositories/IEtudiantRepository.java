package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {

    Etudiant findEtudiantByCin(long cin);
}
