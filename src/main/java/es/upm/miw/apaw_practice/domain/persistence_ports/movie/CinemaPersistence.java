package es.upm.miw.apaw_practice.domain.persistence_ports.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Cinema;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaPersistence {
    Cinema updateMovieTicketPrice(Cinema cinema);

    Cinema readByCinemaName(String cinemaName);
}
