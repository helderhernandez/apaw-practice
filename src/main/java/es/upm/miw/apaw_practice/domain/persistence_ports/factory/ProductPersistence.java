package es.upm.miw.apaw_practice.domain.persistence_ports.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Product;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProductPersistence {
    Stream<Product> readAll();

    Product readBySerialNumber(Long serialNumber);

    Product update(Product product);
}
