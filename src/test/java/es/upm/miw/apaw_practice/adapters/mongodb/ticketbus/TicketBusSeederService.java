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
                PassengerBusEntity.builder().docIdentify("89386661J").name("Juan").familyName("Perez").phone("651112234").email("jpz@upm.es").accesibility(Boolean.FALSE).build(),
                PassengerBusEntity.builder().docIdentify("33909261Q").name("Ana").familyName("Suarez").phone("679998821").email("asz@upm.es").accesibility(Boolean.FALSE).build(),
                PassengerBusEntity.builder().docIdentify("07904440F").name("Claudia").familyName("Wang").phone("760349846").email("cwang@upm.es").accesibility(Boolean.FALSE).build()
        };
        this.passengerBusRepository.saveAll(Arrays.asList(passengers));

        JourneyEntity[] journeys = {
                new JourneyEntity("Madrid", "Barcelona", 5),
                new JourneyEntity("Madrid", "Vigo", 7)
        };
        this.journeyRepository.saveAll(Arrays.asList(journeys));

        TicketBusEntity[] tickets = {
                TicketBusEntity.builder().seat(11).departureTime(null).arriveTime(null).price(new BigDecimal("30.99")).passengerBus(passengers[0]).build(),
                TicketBusEntity.builder().seat(12).departureTime(null).arriveTime(null).price(new BigDecimal("30.99")).passengerBus(passengers[1]).build(),
                TicketBusEntity.builder().seat(31).departureTime(null).arriveTime(null).price(new BigDecimal("45.00")).passengerBus(passengers[0]).build(),
                TicketBusEntity.builder().seat(32).departureTime(null).arriveTime(null).price(new BigDecimal("45.00")).passengerBus(passengers[2]).build()
        };
        this.ticketBusRepository.saveAll(Arrays.asList(tickets));

        BusEntity[] autocars = {
                new BusEntity("Velocity Cars", 40, Boolean.TRUE, Boolean.TRUE, List.of(tickets[0], tickets[1]), List.of(journeys[0])),
                new BusEntity("Flotas Madrid", 30, Boolean.TRUE, Boolean.FALSE, List.of(tickets[2], tickets[3]), List.of(journeys[1]))
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
