package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class TeamPersistenceMongodbIT {

    @Autowired
    TeamPersistenceMongodb teamPersistenceMongodb;

    @Test
    void testFindNameCourtsByTeamName() {
        assertEquals(List.of("Palacio de Deportes", "Palau Blaugrana"  ),
                teamPersistenceMongodb.findNameCourtsByTeamName("Real Madrid").collect(Collectors.toList()));
    }
}
