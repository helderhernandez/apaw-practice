package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmMakerPersistence {

    FilmMaker create(FilmMaker filmMaker);

    FilmMaker readByReference(String reference);

}
