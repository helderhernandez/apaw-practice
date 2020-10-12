package es.upm.miw.apaw_practice.domain.services.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.RentalFilmPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalFilmService {

    private RentalFilmPersistence rentalFilmPersistence;

    @Autowired
    public RentalFilmService(RentalFilmPersistence rentalFilmPersistence) {
        this.rentalFilmPersistence = rentalFilmPersistence;
    }

    public RentalFilm read(String reference){
        return this.rentalFilmPersistence.read(reference);
    }
}
