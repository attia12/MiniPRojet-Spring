package tn.esprit.twin1.EducationSpringApp.services;

import tn.esprit.twin1.EducationSpringApp.entities.Foyer;

import java.util.List;

public interface FoyerService {
    Foyer addFoyer(Foyer foyer);

    List<Foyer> findAllFoyer();

    Foyer findFoyerById(Long id);

    String deleteFoyerById(Long id);
    Foyer updateFoyer(long id, Foyer upfoyer);

    Foyer addFoyerAndAsigneToUni(long idUni, Foyer foyer);
}
