package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.MemberTeam;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MemberTeamPersistence {

    Stream<MemberTeam> readAll();

}
