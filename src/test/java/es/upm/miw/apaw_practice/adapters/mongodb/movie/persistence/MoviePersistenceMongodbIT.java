package es.upm.miw.apaw_practice.adapters.mongodb.movie.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class MoviePersistenceMongodbIT {

    @Autowired
    private MoviePersistenceMongodb moviePersistenceMongodb;

    @Test
    void testFindByCinemaFilmRoomsWithMoreThanNumberOfSeats(){
        assertEquals(6, this.moviePersistenceMongodb.findByCinemaFilmRoomsWithMoreThanNumberOfSeats(100).count());
    }
}
