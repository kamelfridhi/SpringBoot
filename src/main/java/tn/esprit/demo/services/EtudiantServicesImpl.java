package tn.esprit.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.repositories.IEtudiantRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServicesImpl  implements IEtudiantServices {
    IEtudiantRepository etudiantRepo;

    @Override
    public Etudiant ajouterEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return (List<Etudiant>) etudiantRepo.findAll();
    }

}
