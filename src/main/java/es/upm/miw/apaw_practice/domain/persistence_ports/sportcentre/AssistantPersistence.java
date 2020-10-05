package es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AssistantPersistence {

    Assistant updatePhone(String id, int phone);

}
