package es.upm.miw.apaw_practice.domain.services.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AnimalService {

    private final AnimalPersistence animalPersistance;

    @Autowired
    public AnimalService(AnimalPersistence animalPersistance) {
        this.animalPersistance = animalPersistance;
    }

    public Stream<Animal> readAll() {
        return this.animalPersistance.readAll();
    }

    public Animal create(AnimalCreation animalCreation) {
        return this.animalPersistance.create(animalCreation);
    }

    public Animal updateAge(String id, Integer age) {
        return this.animalPersistance.updateAge(id, age);
    }
}
