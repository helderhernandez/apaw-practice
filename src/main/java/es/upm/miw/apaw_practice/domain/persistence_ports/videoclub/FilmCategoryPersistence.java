package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryPersistence {

    FilmCategory readByReference(String reference);

    FilmCategory update(FilmCategory filmCategory);
}
