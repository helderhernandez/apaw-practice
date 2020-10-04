package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.JourneyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketBusSeederService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private TicketBusRepository ticketBusRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private JourneyRepository journeyRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- TicketBus Initial Load -----------");

        PassengerEntity[] passengers = {
                new PassengerEntity("89386661J", "Juan", "Perez", "651112234", "jpz@upm.es", Boolean.FALSE),
                new PassengerEntity("33909261Q", "Ana", "Suarez", "679998821", "asz@upm.es", Boolean.FALSE),
                new PassengerEntity("07904440F", "Claudia", "Wang", "760349846", "cwang@upm.es", Boolean.FALSE)
        };
        this.passengerRepository.saveAll(Arrays.asList(passengers));

        JourneyEntity[] journeys = {
                new JourneyEntity("Madrid", "Barcelona", 5),
                new JourneyEntity("Madrid", "Vigo", 7)
        };
        this.journeyRepository.saveAll(Arrays.asList(journeys));

        TicketBusEntity[] tickets = {
                new TicketBusEntity(11, null, null, new BigDecimal("30.99"), passengers[0]),
                new TicketBusEntity(12, null, null, new BigDecimal("30.99"), passengers[1]),
                new TicketBusEntity(31, null, null, new BigDecimal("45.00"), passengers[0]),
                new TicketBusEntity(32, null, null, new BigDecimal("45.00"), passengers[2])
        };
        this.ticketBusRepository.saveAll(Arrays.asList(tickets));

        BusEntity[] autocars = {
                new BusEntity("COOP-VEL-11", "Velocity Cars", Boolean.TRUE, Boolean.TRUE, List.of(tickets[0], tickets[1]), List.of(journeys[0])),
                new BusEntity("COOP-FM-11", "Flotas Madrid", Boolean.TRUE, Boolean.FALSE, List.of(tickets[2], tickets[3]), List.of(journeys[1]))
        };
        this.busRepository.saveAll(Arrays.asList(autocars));
    }

    public void deleteAll() {
        busRepository.deleteAll();
        ticketBusRepository.deleteAll();
        passengerRepository.deleteAll();
        journeyRepository.deleteAll();
    }

}
