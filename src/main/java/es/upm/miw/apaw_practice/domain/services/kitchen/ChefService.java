package es.upm.miw.apaw_practice.domain.services.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.ChefPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

    private ChefPersistence chefPersistence;

    @Autowired
    public ChefService(ChefPersistence chefPersistence) {
        this.chefPersistence = chefPersistence;
    }

    public Chef updateRecipesFinished(String dni, Integer recipesFinished) {
        return this.chefPersistence.updateRecipesFinished(dni, recipesFinished);
    }
}
