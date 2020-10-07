package es.upm.miw.apaw_practice.domain.services.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void updateAges(List<AnimalAgeUpdating> animalAgeUpdatingList) {
        animalAgeUpdatingList.stream()
                .map(animalNewAge -> {
                    Animal animal = this.animalPersistance.readById(animalNewAge.getId());
                    animal.setAge(animalNewAge.getAge());
                    return animal;
                })
                .forEach(animal -> this.animalPersistance.update(animal));
    }

    public void delete(String id) {
        this.animalPersistance.deleteById(id);
    }
}
