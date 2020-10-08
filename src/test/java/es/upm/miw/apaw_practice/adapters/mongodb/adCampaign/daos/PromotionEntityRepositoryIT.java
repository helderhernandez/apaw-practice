package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.PromotionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PromotionEntityRepositoryIT {

    @Autowired
    private PromotionRepository promotionRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.promotionRepository.findAll().stream().
                anyMatch(promotion -> "promotion-03".equals(promotion.getId()) &&
                        "enero2020".equals(promotion.getTitle()) &&
                        "Inicia con el pie derecho".equals(promotion.getHeader()) &&
                        "Hasta el 20% de descuento en laptops".equals(promotion.getDescription())
                ));
    }

    @Test
    void testSetAndGet() {
        PromotionEntity promotion = new PromotionEntity();
        promotion.setId("id-test");
        promotion.setTitle("testTitle");
        promotion.setHeader("testHeader");
        promotion.setDescription("tesDescription");

        assertEquals("id-test",promotion.getId());
        assertEquals("testTitle",promotion.getTitle());
        assertEquals("testHeader",promotion.getHeader());
        assertEquals("tesDescription",promotion.getDescription());
    }
}
