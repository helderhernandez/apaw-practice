package es.upm.miw.apaw_practice.adapters.mongodb.veterinary;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.ClientEntity;
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
    @Autowired
    private ClientRepository clientRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Shop Initial Load -----------");
        ClientEntity[] clients = {
                new ClientEntity("key-client-ds", "Manuel", "calle Lazaga", "636363654"),
                new ClientEntity("key-client-ssj", "Ulises", "calle Odonell", "435654673")
        };
        this.clientRepository.saveAll(Arrays.asList(clients));

        AnimalEntity[] animals = {
                new AnimalEntity("key-1-a", "Garfield", 6, clients[0]),
                new AnimalEntity("key-10-bd", "Simba", 1, clients[0]),
                new AnimalEntity("key-7-ctg", "Garfield2", 8, clients[1])
        };
        this.animalRepository.saveAll(Arrays.asList(animals));
    }

    public void deleteAll() {
        this.animalRepository.deleteAll();
        this.clientRepository.deleteAll();
    }

}
