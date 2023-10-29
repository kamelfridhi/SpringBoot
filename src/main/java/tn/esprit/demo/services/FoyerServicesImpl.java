package tn.esprit.demo.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Foyer;
import tn.esprit.demo.repositories.IFoyerRepository;
import tn.esprit.demo.repositories.IUniversiteRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FoyerServicesImpl implements IFoyerServices
{

   // @Autowired
    final  IFoyerRepository foyerRepository;


    //public FoyerServicesImpl(IFoyerRepository foyerRepository) {
     //   this.foyerRepository = foyerRepository;
    //}

    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void supprimerFoyer(Long idFoyer)
    {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer getFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer()
    {

        return (List<Foyer>) foyerRepository.findAll();
    }
}
