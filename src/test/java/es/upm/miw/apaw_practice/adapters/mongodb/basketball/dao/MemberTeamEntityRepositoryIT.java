package es.upm.miw.apaw_practice.adapters.mongodb.basketball.dao;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.MemberTeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.MemberTeamEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MemberTeamEntityRepositoryIT {

    @Autowired
    private MemberTeamRepository memberTeamRepository;

    @Test
    void testFindMemberByDni() {
        assertTrue(this.memberTeamRepository.findByDni("20000000C").isPresent());
        MemberTeamEntity memberTeam = this.memberTeamRepository.findByDni("20000000C").get();
        assertEquals("Leonor", memberTeam.getName());
        assertEquals("Rodriguez", memberTeam.getSurname());
    }

}
