package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.JourneyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.JourneyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("journeyPersistence")
public class JourneyPersistenceMongodb implements JourneyPersistence {

    private JourneyRepository journeyRepository;

    @Autowired
    public JourneyPersistenceMongodb(JourneyRepository journeyRepository){
        this.journeyRepository = journeyRepository;
    }

    @Override
    public Stream<Journey> findAll() {
        return this.journeyRepository.findAll().stream()
                .map(JourneyEntity::toJourney);
    }
}
