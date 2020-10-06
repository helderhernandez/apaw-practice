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
        assertEquals(Boolean.TRUE, piece.getInStock());
        assertEquals(0, new BigDecimal(60).compareTo(piece.getPrice()));
    }

    @Test
    void testFindByNameAndManufacturer() {
        assertTrue(this.pieceRepository.findByNameAndManufacturer("Pintura blanca", "Car Colors SL").isPresent());
        PieceEntity piece = this.pieceRepository.findByNameAndManufacturer("Pintura blanca", "Car Colors SL").get();
        assertEquals(Boolean.TRUE, piece.getInStock());
        assertEquals(0, new BigDecimal(100).compareTo(piece.getPrice()));
    }

}
