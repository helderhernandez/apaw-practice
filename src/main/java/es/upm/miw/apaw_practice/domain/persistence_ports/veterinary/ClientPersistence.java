package es.upm.miw.apaw_practice.domain.persistence_ports.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Client;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ClientPersistence {
    Stream<Client> readAll();

}
