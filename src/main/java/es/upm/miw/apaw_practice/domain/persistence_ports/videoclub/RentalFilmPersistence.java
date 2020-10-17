package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalFilmPersistence {

    RentalFilm read(String reference);

    List<String> findByFilmMakerName(String filmMakerName);
}
