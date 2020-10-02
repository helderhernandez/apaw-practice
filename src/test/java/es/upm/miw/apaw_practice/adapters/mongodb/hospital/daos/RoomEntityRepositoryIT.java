package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class RoomEntityRepositoryIT {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void testFindByFloor(){
        assertEquals(2,this.roomRepository.findByFloor(3).orElse(null).size());
        assertEquals("AreaB",this.roomRepository.findByFloor(2).orElse(null).get(0).getArea());
        assertTrue(this.roomRepository.findByFloor(8).orElse(null).isEmpty());
        assertEquals(2,this.roomRepository.findByFloor(1).orElse(null).get(0).getPatientEntities().size());
    }
}
