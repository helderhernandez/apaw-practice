package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DesignEntityRepositoryIT {
    @Autowired
    private DesignRepository designRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(
            this.designRepository
                .findAll()
                .stream()
                .anyMatch(design->
                    design.getCost().equals(new BigDecimal("250.00")) &&
                    design.getFinished().equals(Boolean.FALSE) &&
                    design.getStyle().equals("American Traditional") &&
                    design.getType().equals("collaborative") &&
                    design.getTattoistEntities().get(0).getNickname().equals("JC") &&
                    design.getTattoistEntities().get(0).getName().equals("Joseph Company")
                ));
    }
}
