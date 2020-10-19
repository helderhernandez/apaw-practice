package es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyrental.DiscountSporty;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DiscountSportyPersistence {

    Stream<DiscountSporty> readAll();

    DiscountSporty updateDescription(String idDiscountSporty, Double percentage);

    Stream<String> readDescriptionsDiscountByNumMaxPersonGreaterThan(Integer numMaxPerson);
}
