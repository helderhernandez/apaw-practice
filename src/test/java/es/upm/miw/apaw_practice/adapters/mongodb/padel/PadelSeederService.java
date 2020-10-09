package es.upm.miw.apaw_practice.adapters.mongodb.padel;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.PlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.RacketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.ReservationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.TournamentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.RacketEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.ReservationEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.TournamentEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class PadelSeederService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private RacketRepository racketRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Padel Initial Load -----------");
        ReservationEntity[] reservationEntities = {
                new ReservationEntity(BigDecimal.TEN, LocalDateTime.of(1997,11,11,9,0)),
                new ReservationEntity(BigDecimal.TEN,LocalDateTime.of(1997,11,11,10,30)),
                new ReservationEntity(BigDecimal.TEN,LocalDateTime.of(1998,11,11,12,0)),
                new ReservationEntity(BigDecimal.ONE,LocalDateTime.of(1999,11,11,13,0)),
                new ReservationEntity(BigDecimal.ONE,LocalDateTime.of(2000,11,11,16,0)),
                new ReservationEntity(BigDecimal.ONE,LocalDateTime.of(2001,11,11,17,30)),

        };
        this.reservationRepository.saveAll(Arrays.asList(reservationEntities));

        PlayerEntity[] playerEntities = {
                PlayerEntity.builder().name("Diego").surname("Lusquiños Otera").dni("77013276A").email("lusky1996@gmail.com").federated(false).reservationEntities(reservationEntities[0]).endReservationEntities().build(),
                PlayerEntity.builder().name("Diegoo").surname("Lusquiños Otere").dni("77013276B").email("lusky1997@gmail.com").federated(false).reservationEntities(reservationEntities[1]).endReservationEntities().build(),
                PlayerEntity.builder().name("Diegooo").surname("Lusquiños Oteri").dni("77013276C").email("lusky1998@gmail.com").federated(true).reservationEntities(reservationEntities[2]).endReservationEntities().build(),
                PlayerEntity.builder().name("Diegoooo").surname("Lusquiños Otero").dni("77013276D").email("lusky1999@gmail.com").federated(true).reservationEntities(reservationEntities[3]).reservationEntities(reservationEntities[4]).reservationEntities(reservationEntities[5]).endReservationEntities().build(),
                PlayerEntity.builder().name("Andrea").surname("Lusquiños Oteru").dni("77013276E").email("lusky2000@gmail.com").federated(true).reservationEntities(null).endReservationEntities().build(),

        };
        this.playerRepository.saveAll(Arrays.asList(playerEntities));

        RacketEntity[] racketEntities = {
                new RacketEntity("AAAAA","BRAND-A","ADESCRIPTION",BigDecimal.ONE,"0,1Kg",playerEntities[0]),
                new RacketEntity("BBBBB","BRAND-B","BDESCRIPTION",BigDecimal.ONE,"0,2Kg",playerEntities[0]),
                new RacketEntity("CCCCC","BRAND-A","CDESCRIPTION",BigDecimal.ONE,"0,3Kg",playerEntities[1]),
                new RacketEntity("DDDDD","BRAND-D","DDESCRIPTION",BigDecimal.ONE,"0,4Kg",playerEntities[2]),
                new RacketEntity("DDDDD","BRAND-E","DDESCRIPTION",BigDecimal.ONE,"0,4Kg",playerEntities[4]),


        };
        this.racketRepository.saveAll(Arrays.asList(racketEntities));

        TournamentEntity[] tournamentEntities = {
                new TournamentEntity("TORNEO-A",LocalDateTime.of(2020,12,1,0,0),LocalDateTime.of(2020,12,10,0,0),0, List.of(playerEntities[0],playerEntities[1])),
                new TournamentEntity("TORNEO-A",LocalDateTime.of(2020,12,10,0,0),LocalDateTime.of(2020,12,20,0,0),1, List.of(playerEntities[0],playerEntities[2])),
                new TournamentEntity("TORNEO-B",LocalDateTime.of(2020,12,20,0,0),LocalDateTime.of(2020,12,30,0,0),2, List.of(playerEntities[0],playerEntities[1],playerEntities[2])),
                new TournamentEntity("TORNEO-C",LocalDateTime.of(2021,1,1,0,0),LocalDateTime.of(2021,10,10,0,0),3, List.of(playerEntities)),
                new TournamentEntity("TORNEO-D",LocalDateTime.of(2021,1,1,0,0),LocalDateTime.of(2021,10,10,0,0),4, List.of(playerEntities[4])),

        };
        this.tournamentRepository.saveAll(Arrays.asList(tournamentEntities));


    }

    public void deleteAll() {
        this.reservationRepository.deleteAll();
        this.playerRepository.deleteAll();
        this.racketRepository.deleteAll();
        this.tournamentRepository.deleteAll();
    }
}
