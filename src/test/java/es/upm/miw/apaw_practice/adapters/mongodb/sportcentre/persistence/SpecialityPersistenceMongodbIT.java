package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance.SpecialityPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.models.shop.ShoppingCart;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class SpecialityPersistenceMongodbIT {

    @Autowired
    private SpecialityPersistenceMongodb specialityPersistence;

    @Test
    void testReadAll(){
        Optional<Speciality> speciality = this.specialityPersistence.readAll()
        .filter(spec -> "spec1".equals(spec.getId()))
                .findFirst();
        assertNotNull(speciality.isPresent());
        assertEquals(60, speciality.get().getDuration());
        assertEquals(true, speciality.get().getRecomended());
    }

}
