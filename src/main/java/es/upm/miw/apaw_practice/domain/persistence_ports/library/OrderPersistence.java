package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Order;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface OrderPersistence {
    Stream<Order> readAll();
}
