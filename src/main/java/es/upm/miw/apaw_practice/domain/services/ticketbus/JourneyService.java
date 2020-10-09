package es.upm.miw.apaw_practice.domain.services.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.JourneyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class JourneyService {

    private JourneyPersistence journeyPersistence;

    @Autowired
    public JourneyService(JourneyPersistence journeyPersistence){
        this.journeyPersistence = journeyPersistence;
    }

    public Stream<Journey> findAll(){
        return this.journeyPersistence.findAll();
    }
}
