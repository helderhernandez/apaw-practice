package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.ChefRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.ChefEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.ChefPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("chefPersistence")
public class ChefPersistenceMongodb implements ChefPersistence {

    private ChefRepository chefRepository;

    @Autowired
    public ChefPersistenceMongodb(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    @Override
    public Chef updateRecipesFinished(String dni, Integer recipesFinished) {
        ChefEntity chefEntity = this.chefRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException("Chef dni: " + dni));

        chefEntity.setRecipesFinished(recipesFinished);
        return this.chefRepository.save(chefEntity).toChef();
    }
}
