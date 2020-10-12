package es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory;


import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FurniturePersistence {
    Stream<Furniture> readAll();
    Furniture updateName(String id, String name);
}
