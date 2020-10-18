package es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory;


import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository
public interface FurniturePersistence {
    Stream<Furniture> readAll();
    Furniture updateName(String id, String name);
    BigDecimal findTotalPriceFurnitureByStreet(String street);
}
