package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.AnimalPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("animalPersistance")
public class AnimalPersistanceMongodb implements AnimalPersistance {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalPersistanceMongodb(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @Override
    public Stream<Animal> readAll() {
        return this.animalRepository.findAll().stream()
                .map(AnimalEntity::toAnimal);
    }

    public void assertAnimalKeyNotExist(String animalKey) {
        this.animalRepository
                .findById(animalKey)
                .ifPresent(animal -> {
                    throw new ConflictException("Barcode exist: " + animalKey);
                });
    }

    @Override
    public Animal create(AnimalCreation animalCreation) {
        this.assertAnimalKeyNotExist(animalCreation.getId());
        return this.animalRepository
                .save(new AnimalEntity(animalCreation))
                .toAnimal();
    }
}
