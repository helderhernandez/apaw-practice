package es.upm.miw.apaw_practice.domain.services.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Cinema;
import es.upm.miw.apaw_practice.domain.models.movie.CinemaMovieTicketPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.CinemaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    private CinemaPersistence cinemaPersistence;

    @Autowired
    public CinemaService(CinemaPersistence cinemaPersistence) {
        this.cinemaPersistence = cinemaPersistence;
    }

    public void updateMovieTicketPrice(List<CinemaMovieTicketPriceUpdating> cinemaMovieTicketPriceUpdatingList) {
        cinemaMovieTicketPriceUpdatingList.stream()
                .map(cinemaTicketNewPrice -> {
                    Cinema cinema = this.cinemaPersistence.readByCinemaName(cinemaTicketNewPrice.getCinemaName());
                    cinema.setMovieTicketPrice(cinemaTicketNewPrice.getMovieTicketPrice());
                    return cinema;
                })
                .forEach(cinema -> this.cinemaPersistence.updateMovieTicketPrice(cinema));
    }
}
