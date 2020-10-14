package es.upm.miw.apaw_practice.domain.services.sportyRental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CategorySporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.CategorySportyPersistence;
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
