package es.upm.miw.apaw_practice.adapters.mongodb.basketball;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.CoachRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.CourtRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.MemberTeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CoachEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CourtEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.MemberTeamEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BasketballSeederService {
    @Autowired
    private MemberTeamRepository memberTeamRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private CourtRepository courtRepository;
    @Autowired
    private TeamRepository teamRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Basketball Initial Load -----------");
        MemberTeamEntity[] membersTeam = {
                new MemberTeamEntity("Silvia", "Dominguez", "00000000A", true),
                new MemberTeamEntity("Laia", "Palau", "10000000B", true),
                new MemberTeamEntity("Leonor", "Rodriguez", "20000000C", false),
                new MemberTeamEntity("Cristina", "Ouviña", "30000000D", true),
                new MemberTeamEntity("Sergio", "Llull", "11111111A", true),
                new MemberTeamEntity("Ricky", "Rubio", "21111111B", true),
                new MemberTeamEntity("Rudy", "Fernandez", "31111111C", true),
                new MemberTeamEntity("Pau", "Gasol", "41111111D", false)
        };
        this.memberTeamRepository.saveAll(Arrays.asList(membersTeam));
        CoachEntity[] coachs = {
                new CoachEntity(new CoachCreation("Lucas", "2222222A")),
                new CoachEntity(new CoachCreation("Victor", "12222222B")),
                new CoachEntity(new CoachCreation("Pablo", "32222222C"))
        };
        this.coachRepository.saveAll(Arrays.asList(coachs));
        CourtEntity[] courts = {
                new CourtEntity("Palacio de Deportes", 15500),
                new CourtEntity("Fuente de San Luis", 9000),
                new CourtEntity("Palau Blaugrana", 7500),
                new CourtEntity("Bilbao Arena", 10000)
        };
        this.courtRepository.saveAll(Arrays.asList(courts));
        TeamEntity[] teams = {
                new TeamEntity("Real Madrid", List.of(membersTeam[0], membersTeam[1]), List.of(courts[0], courts[2]), coachs[0]),
                new TeamEntity("Valencia Basket", List.of(membersTeam[2], membersTeam[3]), List.of(courts[0], courts[1], courts[2]), coachs[1]),
                new TeamEntity("Barcelona", List.of(membersTeam[4], membersTeam[5]), List.of(courts[1], courts[2]), coachs[2])
        };
        this.teamRepository.saveAll(Arrays.asList(teams));
    }

    public void deleteAll() {
        this.teamRepository.deleteAll();
        this.courtRepository.deleteAll();
        this.coachRepository.deleteAll();
        this.memberTeamRepository.deleteAll();
    }
}
