package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.AssistantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SpecialityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SportCentreSeederService {

    @Autowired
    private AssistantRepository assistantRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Shop Initial Load -----------");
        AssistantEntity[] assistants = {
                new AssistantEntity("100", "Alejandro", "Rodriguez", 111111111),
                new AssistantEntity("101", "Luis", "Perez", 122222222),
                new AssistantEntity("102", "Jose", "Gonzalez", 133333333),
                new AssistantEntity("103", "Victor", "Castro", 144444444),
                new AssistantEntity("104", "Adrian", "Garcia", 155555555)
        };
        this.assistantRepository.saveAll(Arrays.asList(assistants));
        SpecialityEntity[] specialities = {
                new SpecialityEntity("spec1", "Zumba", "Dance Class", 60, true),
                new SpecialityEntity("spec2", "Yoga", "Strectching and Balance Class", 60, true),
                new SpecialityEntity("spec3", "Indoor Cycling", "Intense HIIT session of Cyling", 30, false),
                new SpecialityEntity("spec4", "Personal Defense", "Fight session for improving personal defense", 45, true),
                new SpecialityEntity("spec5", "Full Body", "Full body session for improving the overall shape", 50, false)
        };
        this.specialityRepository.saveAll(Arrays.asList(specialities));

    }

    public void deleteAll() {
        this.assistantRepository.deleteAll();
        this.specialityRepository.deleteAll();
    }

}
