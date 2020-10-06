package es.upm.miw.apaw_practice.domain.services.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Racket;
import es.upm.miw.apaw_practice.domain.models.padel.RacketPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.RacketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RacketService {
    private RacketPersistence racketPersistence;

    @Autowired
    public RacketService(RacketPersistence racketPersistence) {
        this.racketPersistence = racketPersistence;
    }

    public void uptadePrices(RacketPriceUpdating racketPriceUpdating){
        this.racketPersistence.readByBrand(racketPriceUpdating.getBrand())
                .peek(racket -> racket.setPrice(racket.getPrice().add(racketPriceUpdating.getPrice())))
                .forEach(racket -> this.racketPersistence.update(racket));

    }
}