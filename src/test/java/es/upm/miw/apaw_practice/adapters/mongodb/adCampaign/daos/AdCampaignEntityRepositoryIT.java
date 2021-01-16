package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.AdCampaignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.PromotionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class AdCampaignEntityRepositoryIT {

    @Autowired
    private AdCampaignRepository adCampaignRepository;

    private AdCampaignEntity adCampaign;

    @BeforeEach
    void before() {
        assertFalse(this.adCampaignRepository
                .findByScheduleDate(LocalDateTime.of(2022, 12, 1, 13, 0, 0))
                .isPresent());
        assertTrue(this.adCampaignRepository
                .findByScheduleDate(LocalDateTime.of(2020, 12, 1, 13, 0, 0))
                .isPresent());
        adCampaign = this.adCampaignRepository
                .findByScheduleDate(LocalDateTime.of(2020, 12, 1, 13, 0, 0))
                .get();
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.adCampaignRepository.findAll().stream().
                anyMatch(adCampaign -> "adCampaign-02".equals(adCampaign.getId()) &&
                        LocalDateTime.of(2020, 12, 1, 13, 0, 0).
                                isEqual(adCampaign.getScheduleDate())
                ));
    }

    @Test
    void testSetAndGet() {
        adCampaign.setError(23);
        assertEquals(23, adCampaign.getError());
        adCampaign.setSuccess(250);
        assertEquals(250, adCampaign.getSuccess());
        adCampaign.setStatus("run");
        assertEquals("run", adCampaign.getStatus());
        adCampaign.setId("id391");
        assertEquals("id391", adCampaign.getId());
        LocalDateTime rightNow = LocalDateTime.now();
        adCampaign.setScheduleDate(rightNow);
        assertEquals(rightNow, adCampaign.getScheduleDate());
    }

    @Test
    void testDBRefLikesEntity() {
        LikesEntity likes = adCampaign.getLikesEntity();
        assertEquals("likes-01", likes.getId());
        assertEquals("Artes", likes.getName());
        assertEquals("Pintura, lienzos, pinceles", likes.getDescription());
    }

    @Test
    void testDBRefPromotionEntity() {
        assertTrue(adCampaign.getPromotionEntities().stream()
                .map(PromotionEntity::getId)
                .collect(Collectors.toList())
                .containsAll(List.of("promotion-01", "promotion-03")));
    }
}
