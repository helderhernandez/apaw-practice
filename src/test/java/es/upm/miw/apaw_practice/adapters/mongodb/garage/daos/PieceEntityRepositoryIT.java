package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.PieceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PieceEntityRepositoryIT {

    @Autowired
    private PieceRepository pieceRepository;

    @Test
    void testFindByBarcode() {
        assertTrue(this.pieceRepository.findByBarcode("2124565DF").isPresent());
        PieceEntity piece = this.pieceRepository.findByBarcode("2124565DF").get();
        assertEquals("Luces delanteras led", piece.getName());
        assertEquals(Boolean.TRUE, piece.getInStock());
        assertEquals(0, new BigDecimal(60).compareTo(piece.getPrice()));
    }

}
