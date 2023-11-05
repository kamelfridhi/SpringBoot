package tn.esprit.demo.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.TypeChambre;
import tn.esprit.demo.services.IChambreServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("chambre")
@RestController
public class ChambreRestController {
    private final IChambreServices chambreService;

    @GetMapping("/all")
    public List<Chambre> getAleChambre(){
        return chambreService.getAllChambres();
    }

    @PostMapping("/add")
    public Chambre adeChambre(@RequestBody Chambre ch){
        return chambreService.ajouterChambre(ch);
    }

    @PostMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre ch){
        return chambreService.updateChambre(ch);
    }

    @DeleteMapping ("/delete/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre){
        chambreService.supprimerChambre(idChambre);
    }


    @GetMapping("getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBloc(@PathVariable String nomBloc){
        return chambreService.getChambresParNomBloc(nomBloc);

    }

    @GetMapping("nbChambreParTypeEtBloc/{type}/{idbloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type, @PathVariable long idbloc){
        return chambreService.nbChambreParTypeEtBloc(type,idbloc);

    }

    @GetMapping("getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@PathVariable String nomFoyer, @PathVariable TypeChambre type){
        return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);

    }

}
