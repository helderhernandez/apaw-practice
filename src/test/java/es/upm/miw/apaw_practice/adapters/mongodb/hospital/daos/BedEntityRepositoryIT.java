package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.BedEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class BedEntityRepositoryIT {

    @Autowired
    private BedRepository bedRepository;

    @Test
    void testFindByInternedDate() {
        assertEquals(2, this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 2, 10, 0)).orElse(null).size());
        assertEquals(1, this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 3, 15, 0)).orElse(null).size());
        BedEntity bedEntity = this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 2, 10, 0)).orElse(null).get(0);
        BedEntity bedEntity2 = this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 2, 10, 0)).orElse(null).get(0);
        assertEquals(105, bedEntity.getWidth());
        bedEntity.setWidth(111);
        bedEntity.setHeight(222);
        bedEntity.setOccupied(false);
        String temp = "BedEntity{" +
                "id='" + bedEntity.getId() + '\'' +
                ", width=" + bedEntity.getWidth() +
                ", height=" + bedEntity.getHeight() +
                ", occupied=" + bedEntity.getOccupied() +
                ", roomEntity=" + bedEntity.getRoomEntity() +
                '}';
        assertEquals(temp, bedEntity.toString());
        assertEquals(bedEntity.hashCode(), bedEntity2.hashCode());
        assertTrue(bedEntity.equals(bedEntity2));
        assertTrue(this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 1, 1, 9, 0)).get().isEmpty());
        bedEntity.setWidth(105);
        bedEntity.setHeight(180);
        bedEntity.setOccupied(true);
    }

}
