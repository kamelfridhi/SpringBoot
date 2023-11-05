package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Universite;


public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite(String nom);
}
