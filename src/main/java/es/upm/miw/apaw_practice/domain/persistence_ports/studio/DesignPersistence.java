package es.upm.miw.apaw_practice.domain.persistence_ports.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Consumer;
import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DesignPersistence {

    Design create(DesignCreation designCreation);

    Stream<Consumer> findConsumersByTypeDesign(String type);
}
