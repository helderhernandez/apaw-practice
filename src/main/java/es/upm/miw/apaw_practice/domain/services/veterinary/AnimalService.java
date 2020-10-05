package es.upm.miw.apaw_practice.domain.services.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.AnimalPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AnimalService {

    private final AnimalPersistance animalPersistance;

    @Autowired
    public AnimalService(AnimalPersistance animalPersistance) {
        this.animalPersistance = animalPersistance;
    }

    public Stream<Animal> readAll() {
        return this.animalPersistance.readAll();
    }

}
