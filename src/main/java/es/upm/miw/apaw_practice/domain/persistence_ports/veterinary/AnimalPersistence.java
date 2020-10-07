package es.upm.miw.apaw_practice.domain.persistence_ports.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AnimalPersistence {
    Stream<Animal> readAll();

    Animal readById(String id);

    Animal create(AnimalCreation animalCreation);

    Animal updateAge(String id, Integer age);
}
