package es.upm.miw.apaw_practice.domain.persistence_ports.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TattoistPersistence {

    Stream<Tattoist> readAll();

}
