package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class CategorySportyEntityRepositoryIT {

    @Autowired
    private CategorySportyRepository categorySportyRepository;


    @Test
    void testFindById() {
        assertTrue(categorySportyRepository.findById("1").isPresent());
        CategorySportyEntity category = this.categorySportyRepository.findById("1").get();
        assertEquals("Football 7", category.getDescription());
        assertEquals(7, category.getNumMaxPersons());
    }


    @Test
    void testCategoryCreateAndGet() {
        CategorySportyEntity category = new CategorySportyEntity("5", "Badminton", 2);
        this.categorySportyRepository.save(category);
        assertTrue(this.categorySportyRepository.findAll().stream().
                anyMatch(customer -> "5".equals(customer.getIdCategory())
                ));
    }

    @Test
    void testCategorySet() {
        assertTrue(categorySportyRepository.findById("4").isPresent());
        CategorySportyEntity category = this.categorySportyRepository.findById("4").get();
        category.setDescription("FutSal");
        category.setNumMaxPersons(10);

        assertEquals("FutSal", category.getDescription());
        assertEquals(10, category.getNumMaxPersons());
    }
}
