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
                new ReservationEntity(BigDecimal.TEN,LocalDate.of(1996,11,11)),
                new ReservationEntity(BigDecimal.TEN,LocalDate.of(1997,11,11)),
                new ReservationEntity(BigDecimal.TEN,LocalDate.of(1998,11,11)),
                new ReservationEntity(BigDecimal.ONE,LocalDate.of(1999,11,11)),
                new ReservationEntity(BigDecimal.ONE,LocalDate.of(2000,11,11)),
                new ReservationEntity(BigDecimal.ONE,LocalDate.of(2001,11,11)),

        };
        this.reservationRepository.saveAll(Arrays.asList(reservationEntities));

        PlayerEntity[] playerEntities = {
                new PlayerEntity("Diego", "Lusquiños Otera", "77013276A", "lusky1996@gmail.com", false, List.of(reservationEntities[0])),
                new PlayerEntity("Diegoo", "Lusquiños Otere", "77013276B", "lusky1997@gmail.com", false, List.of(reservationEntities[1])),
                new PlayerEntity("Diegooo", "Lusquiños Oteri", "77013276C", "lusky1998@gmail.com", true,List.of(reservationEntities[2])),
                new PlayerEntity("Diegoooo", "Lusquiños Otero", "77013276D", "lusky1999@gmail.com", true, List.of(reservationEntities[3],reservationEntities[4],reservationEntities[5]))

        };
        this.playerRepository.saveAll(Arrays.asList(playerEntities));

        RacketEntity[] racketEntities = {
                new RacketEntity("AAAAA","BRAND-A","ADESCRIPTION",BigDecimal.ONE,"0,1Kg",playerEntities[0]),
                new RacketEntity("BBBBB","BRAND-B","BDESCRIPTION",BigDecimal.ONE,"0,2Kg",playerEntities[0]),
                new RacketEntity("CCCCC","BRAND-A","CDESCRIPTION",BigDecimal.ONE,"0,3Kg",playerEntities[1]),
                new RacketEntity("DDDDD","BRAND-D","DDESCRIPTION",BigDecimal.ONE,"0,4Kg",playerEntities[2]),

        };
        this.racketRepository.saveAll(Arrays.asList(racketEntities));

        TournamentEntity[] tournamentEntities = {
                new TournamentEntity("TORNEO-A",LocalDate.of(2020,12,1),LocalDate.of(2020,12,10),0, List.of(playerEntities[0],playerEntities[1])),
                new TournamentEntity("TORNEO-A",LocalDate.of(2020,12,10),LocalDate.of(2020,12,20),1, List.of(playerEntities[0],playerEntities[2])),
                new TournamentEntity("TORNEO-B",LocalDate.of(2020,12,20),LocalDate.of(2020,12,30),2, List.of(playerEntities[0],playerEntities[1],playerEntities[2])),
                new TournamentEntity("TORNEO-C",LocalDate.of(2021,1,1),LocalDate.of(2021,10,10),3, List.of(playerEntities)),

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
