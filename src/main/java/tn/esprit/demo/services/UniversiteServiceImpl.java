package tn.esprit.demo.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Foyer;
import tn.esprit.demo.entities.Universite;
import tn.esprit.demo.repositories.IFoyerRepository;
import tn.esprit.demo.repositories.IUniversiteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImpl implements IUniversiteServices {
    IUniversiteRepository universiteRepo;
    IFoyerRepository foyerRepository;
    @Override
    public Universite ajouterUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepo.findAll();
    }

    @Override
    public Universite findbyNomuniv(String nom) {
        return universiteRepo.findByNomUniversite(nom);
    }
    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite)
    {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite uni = universiteRepo.findByNomUniversite(nomUniversite);
        if (f != null && uni != null) {
            uni.setFoyer(f);
            return uni;

        }
        return null;
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite u = universiteRepo.findById(idUniversite).orElse(null);
        if (f != null && u != null) {
            u.setFoyer(null);
            return u;
        }

        return null;
    }







}
