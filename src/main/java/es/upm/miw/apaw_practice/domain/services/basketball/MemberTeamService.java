package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.MemberTeam;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.MemberTeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MemberTeamService {

    private MemberTeamPersistence memberTeamPersistence;

    @Autowired
    public MemberTeamService(MemberTeamPersistence memberTeamPersistence) {
        this.memberTeamPersistence = memberTeamPersistence;
    }

    public Stream<MemberTeam> readAll() {
        return this.memberTeamPersistence.readAll();
    }
}
