package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.AssistantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.InstructorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SessionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SpecialityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.InstructorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SessionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class SportCentreSeederService {

    @Autowired
    private AssistantRepository assistantRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private SessionRepository sessionRepository;


    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Shop Initial Load -----------");
        AssistantEntity[] assistants = {
                new AssistantEntity("100", "Alejandro", "Rodriguez", 111111111),
                new AssistantEntity("101", "Julia", "Perez", 122222222),
                new AssistantEntity("102", "Jose", "Gonzalez", 133333333),
                new AssistantEntity("103", "Elena", "Castro",144444444),
                new AssistantEntity("104", "Adrian", "Garcia",155555555)
        };
        this.assistantRepository.saveAll(Arrays.asList(assistants));
        SpecialityEntity[] specialities = {
                new SpecialityEntity("spec1", "Zumba", "Dance Class", 60, true),
                new SpecialityEntity("spec2", "Yoga", "Strectching and Balance Class", 70, true),
                new SpecialityEntity("spec3", "Indoor Cycling", "Intense HIIT session of Cyling", 30, false),
                new SpecialityEntity("spec4", "Personal Defense", "Fight session for improving personal defense", 45, true),
                new SpecialityEntity("spec5", "Full Body", "Full body session for improving the overall shape", 50, false)
        };
        this.specialityRepository.saveAll(Arrays.asList(specialities));
        InstructorEntity[] instructors = {
                new InstructorEntity("11111111A", "Javier", "Rodriguez", BigDecimal.valueOf(1000), List.of(specialities[0])),
                new InstructorEntity("11111111B", "Gonzalo", "Sanchez", BigDecimal.valueOf(900), List.of(specialities[1])),
                new InstructorEntity("11111111C", "Maria", "Jurado", BigDecimal.valueOf(1200), List.of(specialities[2])),
                new InstructorEntity("11111111D", "Javier", "Fernandez", BigDecimal.valueOf(1200), List.of(specialities[3])),
                new InstructorEntity("11111111E", "Teresa", "Izquierdo", BigDecimal.valueOf(1000), List.of(specialities[3], specialities[4]))
        };
        this.instructorRepository.saveAll(Arrays.asList(instructors));
        SessionEntity[] sessions = {
                new SessionEntity("S00", 1, List.of(), instructors[0]),
                new SessionEntity("S01", 2, List.of(assistants[1], assistants[3]), instructors[1]),
                new SessionEntity("S02", 3, List.of(assistants[0], assistants[1], assistants[4]), instructors[2]),
                new SessionEntity("S03", 4, List.of(assistants[2], assistants[3]), instructors[3]),
                new SessionEntity("S04", 5, List.of(assistants[4]), instructors[4]),
                new SessionEntity("S05", 6, List.of(assistants[0],assistants[3],assistants[4], assistants[1]), instructors[1]),
                new SessionEntity("S06", 7, List.of(assistants[2]), instructors[2]),
                new SessionEntity("S07", 8, List.of(assistants[1], assistants[2]), instructors[3])
        };
        this.sessionRepository.saveAll(Arrays.asList(sessions));
    }

    public void deleteAll() {
        this.assistantRepository.deleteAll();
        this.specialityRepository.deleteAll();
    }

}