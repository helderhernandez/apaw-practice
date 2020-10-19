package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CategorySporty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CategorySportyPersistenceMongodbIT {

    @Autowired
    private CategorySportyPersistenceMongodb categorySportyPersistenceMongodb;

    @Autowired
    private SportyRentalSeederService sportyRentalSeederService;

    @Test
    void testUpdateAndReset() {

        Optional<CategorySporty> categorySportyOptional = this.categorySportyPersistenceMongodb.readAll().filter(category -> "3".equals(category.getIdCategory())).findFirst();
        assertNotNull(categorySportyOptional);
        assertTrue(categorySportyOptional.isPresent());
        CategorySporty categorySporty=categorySportyOptional.get();

        CategoryCreationSporty categoryCreationSporty = new CategoryCreationSporty("Fronton", 4);

        categorySporty = categorySportyPersistenceMongodb.update(categorySporty.getIdCategory(), categoryCreationSporty);
        assertEquals("3", categorySporty.getIdCategory());
        assertEquals("Fronton", categorySporty.getDescription());
        assertEquals(4, categorySporty.getNumMaxPersons());
        categoryCreationSporty.setDescription("Tennis");
        categoryCreationSporty.setNumMaxPersons(2);
        categorySportyPersistenceMongodb.update(categorySporty.getIdCategory(), categoryCreationSporty);
    }
}
