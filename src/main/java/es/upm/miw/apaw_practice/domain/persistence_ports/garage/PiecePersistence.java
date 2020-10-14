package es.upm.miw.apaw_practice.domain.persistence_ports.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Piece;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PiecePersistence {
    Piece updatePrice(String barcode, BigDecimal price);
}
