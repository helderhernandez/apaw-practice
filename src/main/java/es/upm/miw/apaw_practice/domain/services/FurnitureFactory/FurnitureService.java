package es.upm.miw.apaw_practice.domain.services.FurnitureFactory;

import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.FurniturePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FurnitureService {
    private final FurniturePersistence furniturePersistence;

    @Autowired
    public FurnitureService(FurniturePersistence furniturePersistence) {
        this.furniturePersistence = furniturePersistence;
    }
    public Stream<Furniture> readAll() {
        return this.furniturePersistence.readAll();
    }

    public Furniture updateName(String id, String name) {
        return this.furniturePersistence.updateName(id, name);
    }

}
