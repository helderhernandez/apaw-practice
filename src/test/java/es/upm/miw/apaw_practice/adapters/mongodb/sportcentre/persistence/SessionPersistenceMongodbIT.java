package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance.InstructorPersistenceMongodb;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance.SessionPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class SessionPersistenceMongodbIT {

    @Autowired
    private SessionPersistenceMongodb sessionPersistence;
    @Autowired
    private InstructorPersistenceMongodb instructorPersistence;


    @Test
    void testFindNameAssistantsSessionByInstructor(){
        List<String> assistants = this.sessionPersistence.findNameAssistantsSessionByInstructor("Gonzalo").collect(Collectors.toList());
        assertTrue(assistants.get(0).contains("Julia"));
        assertTrue(assistants.get(1).contains("Elena"));
    }

    @Test
    void testFindSessionBySpeciality(){
        Instructor instructor = this.instructorPersistence.readBySpecialityTitle("Yoga");
        Session session = this.sessionPersistence.findSessionByInstructor(instructor);
        assertEquals(2, session.getRoomNumber());
    }
}
