package es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CategorySporty;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CategorySportyPersistence {

    Stream<CategorySporty> readAll();

    CategorySporty update(String idCategorySporty, CategoryCreationSporty categoryCreationSporty);
}
