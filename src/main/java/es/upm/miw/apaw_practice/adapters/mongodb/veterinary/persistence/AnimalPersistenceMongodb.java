package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("animalPersistence")
public class AnimalPersistenceMongodb implements AnimalPersistence {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalPersistenceMongodb(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal readById(String id) {
        return this.animalRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Animal ID: " + id))
                .toAnimal();
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
                    throw new ConflictException("AnimalKey exist: " + animalKey);
                });
    }

    @Override
    public Animal create(AnimalCreation animalCreation) {
        this.assertAnimalKeyNotExist(animalCreation.getId());
        return this.animalRepository
                .save(new AnimalEntity(animalCreation))
                .toAnimal();
    }

    @Override
    public Animal updateAge(String id, Integer age) {
        AnimalEntity animalEntity = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal id: " + id));
        animalEntity.setAge(age);
        return this.animalRepository.save(animalEntity).toAnimal();
    }
}
