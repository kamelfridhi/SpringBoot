package tn.esprit.demo.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.services.IBlocServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("bloc")
@RestController
@CrossOrigin(origins = "*")
public class BlocRestController {

    private final IBlocServices blocService;

    @GetMapping("/all")
    public List<Bloc> getAllBloc(){
        return blocService.getAllBlocs();
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc b){
        return blocService.ajouterBloc(b);
    }

    @PostMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc b){
        return blocService.updateBloc(b);
    }

    @DeleteMapping ("/delete/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc){
        blocService.supprimerBloc(idBloc);
    }

    @PutMapping("affecteChambre/{nom}")
    public Bloc affecterChambreBloc(@RequestBody List<Long>numChambre,@PathVariable String nom)
    {
        return blocService.affecterChambresABloc(numChambre,nom);
    }



    @PutMapping("assignRoomsToBlock/{blockName}")
    public Bloc assignRoomsToBlock(@RequestBody List<Long> roomIds, @PathVariable String blockName) {

        return blocService.affecterChambresABloc(roomIds, blockName);

    }


    @PutMapping("affecterBlocAFoyer/{nomBloc}/{nomFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable  String nomBloc, @PathVariable String nomFoyer)
    {
        return blocService.affecterBlocAFoyer(nomBloc,nomFoyer);
    }


}
