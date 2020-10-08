package es.upm.miw.apaw_practice.domain.services.padel;

import es.upm.miw.apaw_practice.domain.models.padel.RacketPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.RacketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class RacketService {
    private RacketPersistence racketPersistence;

    @Autowired
    public RacketService(RacketPersistence racketPersistence) {
        this.racketPersistence = racketPersistence;
    }

    public void uptadePrices(RacketPriceUpdating racketPriceUpdating) {
        this.racketPersistence.readByBrand(racketPriceUpdating.getBrand())
                .peek(racket -> racket.setPrice(racket.getPrice().add(racketPriceUpdating.getPrice())))
                .forEach(racket -> this.racketPersistence.update(racket));

    }

    public void delete(String id) {
        this.racketPersistence.deleteById(id);
    }

    public Stream<String> findBrandRacketPlayersToPlayInLevelTournamentGreaterThan(Integer level) {
        return this.racketPersistence.findBrandRacketPlayersToPlayInLevelTournamentGreaterThan(level);
    }
}
