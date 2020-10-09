package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FurnitureEntityRepositoryIT {

    @Autowired
    private FurnitureRepository furnitureRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.furnitureRepository.findAll().stream()
                .anyMatch(furniture ->
                        "Bed".equals(furniture.getName())&&
                                furniture.getId() != null &&
                                new BigDecimal("89.90").equals(furniture.getPrice()) &&
                                LocalDate.of(2020, 6, 1).equals(furniture.getDateOfManufacture()) &&
                                11000L == furniture.getSerialNumber()
                ));
    }
}
