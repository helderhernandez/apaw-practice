package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalFilmPersistence {

    RentalFilm read(String reference);

}
