package es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyrental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.CategorySporty;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CategorySportyPersistence {

    Stream<CategorySporty> readAll();

    CategorySporty update(String idCategorySporty, CategoryCreationSporty categoryCreationSporty);
}
