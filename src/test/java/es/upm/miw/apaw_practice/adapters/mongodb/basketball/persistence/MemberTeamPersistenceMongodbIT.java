package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.MemberTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class MemberTeamPersistenceMongodbIT {

    @Autowired
    private MemberTeamPersistenceMongodb memberTeamPersistenceMongodb;

    @Test
    void testReadAll() {
        MemberTeam memberTeam = new MemberTeam();
        if (this.memberTeamPersistenceMongodb.readAll().findFirst().isPresent()) {
            memberTeam = this.memberTeamPersistenceMongodb.readAll().findFirst().get();
        }
        assertNotNull(memberTeam.getId());
        assertEquals("Silvia", memberTeam.getName());
        assertEquals("Dominguez", memberTeam.getSurname());
        assertEquals("00000000A", memberTeam.getDni());
        assertTrue(memberTeam.getAvailable());
    }
}
