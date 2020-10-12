package es.upm.miw.apaw_practice.adapters.mongodb.airport;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.FlightRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PlaneRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PlaneEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.SuitcaseEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class AirportSeederService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PlaneRepository planeRepository;

    public void seedDataBase() {
        LogManager.getLogger(this.getClass()).warn("------- Airport Initial Load -----------");
        PlaneEntity[] planeEntities = {
                new PlaneEntity("model1", 100, false, "11111"),
                new PlaneEntity("model2", 105, false, "11112"),
                new PlaneEntity("model1", 175, true, "11113")

        };
        this.planeRepository.saveAll(Arrays.asList(planeEntities));

        FlightEntity[] flightEntities = {
                new FlightEntity(LocalDateTime.of(2020, 10, 10, 20, 20, 20), new BigDecimal("20.50"), planeEntities[0], "madrid"),
                new FlightEntity(LocalDateTime.of(2020, 11, 10, 20, 20, 20), new BigDecimal("20.50"), planeEntities[1], "dublin"),
                new FlightEntity(LocalDateTime.of(2020, 5, 10, 20, 20, 20), new BigDecimal("20.50"), planeEntities[2], "london"),

        };
        this.flightRepository.saveAll(Arrays.asList(flightEntities));

        SuitcaseEntity[] suitcaseEntities = {
                new SuitcaseEntity("red", 5d, "manufacturer1"),
                new SuitcaseEntity("black", 5.5d, "manufacturer1"),
                new SuitcaseEntity("white", 5d, "manufacturer2"),
        };

        PassengerEntity[] passengerEntities = {
                new PassengerEntity("sergio", "garcia", Arrays.asList(suitcaseEntities[0], suitcaseEntities[1]), Arrays.asList(flightEntities[0], flightEntities[1])),
                new PassengerEntity("pablo", "perez", Arrays.asList(suitcaseEntities[2]), Arrays.asList(flightEntities[2]))
        };
        this.passengerRepository.saveAll(Arrays.asList(passengerEntities));

    }

    public void deleteAll() {
        this.passengerRepository.deleteAll();
        this.flightRepository.deleteAll();
        this.planeRepository.deleteAll();
    }
}
