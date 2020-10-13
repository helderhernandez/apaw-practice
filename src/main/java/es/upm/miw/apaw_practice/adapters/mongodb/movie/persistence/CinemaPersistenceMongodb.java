package es.upm.miw.apaw_practice.adapters.mongodb.movie.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.CinemaRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.CinemaEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.movie.Cinema;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.CinemaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("cinemaPersistence")
public class CinemaPersistenceMongodb implements CinemaPersistence {

    private CinemaRepository cinemaRepository;

    @Autowired
    public CinemaPersistenceMongodb(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Cinema updateMovieTicketPrice(Cinema cinema) {
        CinemaEntity cinemaEntity = this.cinemaRepository
                .findById(cinema.getId())
                .orElseThrow(() -> new NotFoundException("Cinema id: " + cinema.getId()));
        cinemaEntity.fromCinema(cinema);
        return this.cinemaRepository
                .save(cinemaEntity)
                .toCinema();
    }

    @Override
    public Cinema readByCinemaName(String cinemaName) {
        return this.cinemaRepository
                .findByCinemaName(cinemaName)
                .orElseThrow(() -> new NotFoundException("Article barcode: " + cinemaName))
                .toCinema();
    }

    @Override
    public Stream<Cinema> findByNameAndFulNameDirector(String name, String fulName) {
        return this.cinemaRepository.findAll().stream()
                .map(CinemaEntity::toCinema)
                .filter(cinema -> cinema.getMovies().stream()
                    .anyMatch(movieEntity -> movieEntity.getFilmDirector().getName().equals(name) &&
                                                movieEntity.getFilmDirector().getFullName().equals(fulName)))
                .distinct();
    }
}
