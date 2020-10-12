package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.RentalFilmRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.RentalFilmPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rentalFilmPersistence")
public class RentalFilmPersistenceMongodb implements RentalFilmPersistence {

    private RentalFilmRepository rentalFilmRepository;

    @Autowired
    public RentalFilmPersistenceMongodb(RentalFilmRepository rentalFilmRepository) {
        this.rentalFilmRepository = rentalFilmRepository;
    }

    @Override
    public RentalFilm read(String reference) {
        return this.rentalFilmRepository.findByReference(reference)
                .orElseThrow(() -> new NotFoundException("Reference: " + reference))
                .toRentalFilm();
    }
}
