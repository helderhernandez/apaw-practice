package es.upm.miw.apaw_practice.adapters.mongodb.veterinary;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.SurgeryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.VeterinaryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.ClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.SurgeryEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.VeterinaryEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class VeterinarySeederService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VeterinaryRepository veterinaryRepository;
    @Autowired
    private SurgeryRepository surgeryRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Veterinary Initial Load -----------");
        ClientEntity[] clients = {
                ClientEntity.builder().id("key-client-ds").name("Manuel").address("calle Lazaga").phone("636363654").build(),
                ClientEntity.builder().id("key-client-ssj").name("Ulises").address("calle Odonell").phone("435654673").build()
        };
        this.clientRepository.saveAll(Arrays.asList(clients));

        VeterinaryEntity[] veterinarians = {
                new VeterinaryEntity("key-vet-365", "Sonsoles", 42),
                new VeterinaryEntity("key-vet-jdnhc", "Joaquin", 46)
        };
        this.veterinaryRepository.saveAll(Arrays.asList(veterinarians));
        LocalDateTime date = LocalDateTime.now();
        AnimalEntity[] animals = {
                new AnimalEntity("key-1-a", "Garfield", 6, date, true, clients[0]),
                new AnimalEntity("key-10-bd", "Simba", 1, date, true, clients[0]),
                new AnimalEntity("key-7-ctg", "Garfield2", 8, date, true, clients[1])
        };
        this.animalRepository.saveAll(Arrays.asList(animals));

        SurgeryEntity[] surgeries = {
                new SurgeryEntity("key-1-a", "heart", new BigDecimal("1249.99"), List.of(veterinarians[0]), List.of(animals[0])),
                new SurgeryEntity("key-10-bd", "spinal", new BigDecimal("345.23"), List.of(veterinarians[1]), List.of(animals[1], animals[2])),
                new SurgeryEntity("key-7-ctg", "bypass", new BigDecimal("699.99"), List.of(veterinarians[1]), List.of(animals[0]))

        };
        this.surgeryRepository.saveAll(Arrays.asList(surgeries));
    }

    public void deleteAll() {
        this.surgeryRepository.deleteAll();
        this.animalRepository.deleteAll();
        this.clientRepository.deleteAll();
        this.veterinaryRepository.deleteAll();
    }

}
