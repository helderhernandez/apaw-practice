package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.CinemaEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmRoomEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CinemaEntityRepositoryIT {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Test
    void testFindByBarcode() {
        assertTrue(this.cinemaRepository.findByCinemaName("YelmoCine").isPresent());
        CinemaEntity cinema = this.cinemaRepository.findByCinemaName("YelmoCine").get();
        assertTrue(cinema.getId() != null);
        assertTrue(cinema.getMovies().stream()
                .map(MovieEntity::getFilmTitle)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("Frozen", "Kill", "Deadpool")));
        assertTrue(cinema.getFilmRooms().stream()
                .map(FilmRoomEntity::getNumberFilmRoom)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(12, 14)));
        assertTrue(cinema.getFilmRooms().stream()
                .map(FilmRoomEntity::getNumberOfSeats)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(150, 85)));
        assertTrue(cinema.getFilmRooms().stream()
                .map(FilmRoomEntity::isLaserScreen)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(true, false)));
        assertEquals(0, new BigDecimal("10.23").compareTo(cinema.getMovieTicketPrice()));
        assertEquals("Alcorcon", cinema.getCity());
    }
}