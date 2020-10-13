package es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory;

import org.springframework.stereotype.Repository;

@Repository
public interface AddressPersistence {
    void deleteById(String id);
}
