package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.TagEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ExtraEntityRepositoryIT {

    @Autowired
    private ExtraRepository extraRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.extraRepository.findAll().stream()
                .anyMatch(extra ->
                        1 == extra.getWorkedHours() &&
                                extra.getPaid()));
    }
}
