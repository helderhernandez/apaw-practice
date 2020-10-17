package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.MemberTeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.MemberTeamEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.MemberTeam;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.MemberTeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("memberTeamPersistence")
public class MemberTeamPersistenceMongodb implements MemberTeamPersistence {

    private MemberTeamRepository memberTeamRepository;

    @Autowired
    public MemberTeamPersistenceMongodb(MemberTeamRepository memberTeamRepository) {
        this.memberTeamRepository = memberTeamRepository;
    }

    @Override
    public Stream<MemberTeam> readAll() {
        return this.memberTeamRepository.findAll().stream()
                .map(MemberTeamEntity::toMemberTeam);
    }

}
