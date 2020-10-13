package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.JourneyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.PassengerBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketBusSeederService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private TicketBusRepository ticketBusRepository;
    @Autowired
    private PassengerBusRepository passengerBusRepository;
    @Autowired
    private JourneyRepository journeyRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- TicketBus Initial Load -----------");

        PassengerBusEntity[] passengers = {
                new PassengerBusEntity("89386661J", "Juan", "Perez", "651112234", "jpz@upm.es", Boolean.FALSE),
                new PassengerBusEntity("33909261Q", "Ana", "Suarez", "679998821", "asz@upm.es", Boolean.FALSE),
                new PassengerBusEntity("07904440F", "Claudia", "Wang", "760349846", "cwang@upm.es", Boolean.FALSE)
        };
        this.passengerBusRepository.saveAll(Arrays.asList(passengers));

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
                new BusEntity( "Velocity Cars", 40, Boolean.TRUE, Boolean.TRUE, List.of(tickets[0], tickets[1]), List.of(journeys[0])),
                new BusEntity( "Flotas Madrid", 30, Boolean.TRUE, Boolean.FALSE, List.of(tickets[2], tickets[3]), List.of(journeys[1]))
        };
        this.busRepository.saveAll(Arrays.asList(autocars));
    }

    public void deleteAll() {
        busRepository.deleteAll();
        ticketBusRepository.deleteAll();
        passengerBusRepository.deleteAll();
        journeyRepository.deleteAll();
    }

}
