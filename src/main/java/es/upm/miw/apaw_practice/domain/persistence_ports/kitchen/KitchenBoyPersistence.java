package es.upm.miw.apaw_practice.domain.persistence_ports.kitchen;

import org.springframework.stereotype.Repository;

@Repository
public interface KitchenBoyPersistence {
    void delete(String dni);
}
