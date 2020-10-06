package es.upm.miw.apaw_practice.adapters.mongodb.padel.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.RacketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.RacketEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.padel.Racket;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.RacketPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository("RacketPersistence")
public class RacketPersistenceMongodb implements RacketPersistence {
    private RacketRepository racketRepository;

    @Autowired
    public RacketPersistenceMongodb(RacketRepository racketRepository) {
        this.racketRepository = racketRepository;
    }

    public Racket update(Racket racket){
        RacketEntity racketEntity = this.racketRepository.findById(racket.getId())
                .orElseThrow(()-> new NotFoundException("Racket id:" + racket.getId()));

        racketEntity.fromRacket(racket);
        return this.racketRepository
                .save(racketEntity)
                .toRacket();
    }

    @Override
    public Stream<Racket> readByBrand(String brand) {
        if(this.racketRepository.findAllByBrand(brand).get().size()==0){
            System.out.println("EEEEE");
            throw new NotFoundException("AA");
        }
        return this.racketRepository.findAllByBrand(brand)
                .orElseThrow(()-> new NotFoundException("Racket brand: " + brand))
                .stream()
                .map(RacketEntity::toRacket);
    }
}
