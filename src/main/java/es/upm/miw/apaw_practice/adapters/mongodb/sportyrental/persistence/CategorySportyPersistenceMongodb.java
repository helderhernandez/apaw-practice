package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.CategorySportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CategorySporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental.CategorySportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("categorySportyPersistence")
public class CategorySportyPersistenceMongodb implements CategorySportyPersistence {

    private CategorySportyRepository categorySportyRepository;

    @Autowired
    public CategorySportyPersistenceMongodb(CategorySportyRepository categorySportyRepository) {
        this.categorySportyRepository = categorySportyRepository;
    }

    @Override
    public Stream<CategorySporty> readAll() {
        return this.categorySportyRepository.findAll().stream().map(CategorySportyEntity::convertToCategorySporty);
    }

    @Override
    public CategorySporty update(String idCategorySporty, CategoryCreationSporty categoryCreationSporty) {
        CategorySportyEntity categorySportyEntity = this.categorySportyRepository.findById(idCategorySporty)
                .orElseThrow(() -> new NotFoundException("CategorySporty id: " + idCategorySporty));
        categorySportyEntity.setDescription(categoryCreationSporty.getDescription());
        categorySportyEntity.setNumMaxPersons(categoryCreationSporty.getNumMaxPersons());
        return this.categorySportyRepository.save(categorySportyEntity).convertToCategorySporty();
    }
}
