package es.upm.miw.apaw_practice.adapters.mongodb.veterinary;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class VeterinarySeederService {

    @Autowired
    private AnimalRepository animalRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Shop Initial Load -----------");
        AnimalEntity[] animals = {
                new AnimalEntity("key-1-a", "Garfield", 6),
                new AnimalEntity("key-10-bd", "Simba", 1),
                new AnimalEntity("key-7-ctg", "Garfield2", 8)
        };
        this.animalRepository.saveAll(Arrays.asList(animals));
    }

    public void deleteAll() {
        this.animalRepository.deleteAll();
    }

}
