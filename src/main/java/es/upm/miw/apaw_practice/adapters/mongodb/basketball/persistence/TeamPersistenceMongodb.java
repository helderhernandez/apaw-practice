package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CourtEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Stream;

@Repository("teamPersistence")
public class TeamPersistenceMongodb implements TeamPersistence {

    private TeamRepository teamRepository;

    @Autowired
    public TeamPersistenceMongodb(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void deleteById(String id) {
        this.teamRepository.deleteById(id);
    }

    @Override
    public Stream<String> findNameCourtsByTeamName(String name) {
        return this.teamRepository.findAll()
                .stream()
                .filter(team -> team.getName().equals(name))
                .map(TeamEntity::getCourtsToPlay)
                .flatMap(Collection::stream)
                .map(CourtEntity::getName)
                .distinct();
    }


}
