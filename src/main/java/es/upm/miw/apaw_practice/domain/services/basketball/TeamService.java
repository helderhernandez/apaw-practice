package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private TeamPersistence teamPersistence;

    @Autowired
    public TeamService(TeamPersistence teamPersistence) {
        this.teamPersistence = teamPersistence;
    }

    public void delete(String id) {
        this.teamPersistence.deleteById(id);
    }
}
