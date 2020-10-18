package es.upm.miw.apaw_practice.domain.services.sportyRental;

import es.upm.miw.apaw_practice.domain.models.sportyrental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CategorySporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental.CategorySportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorySportyService {

    private CategorySportyPersistence categorySportyPersistence;

    @Autowired
    public CategorySportyService(CategorySportyPersistence categorySportyPersistence) {
        this.categorySportyPersistence = categorySportyPersistence;
    }

    public CategorySporty update(String idCategorySporty, CategoryCreationSporty categoryCreationSporty) {
        return this.categorySportyPersistence.update(idCategorySporty, categoryCreationSporty);
    }
}
