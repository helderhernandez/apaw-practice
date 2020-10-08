package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.shop.Tag;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface WorkerPersistence {

    Worker read(String dni);

}
