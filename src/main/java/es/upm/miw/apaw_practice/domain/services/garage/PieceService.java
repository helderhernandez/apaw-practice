package es.upm.miw.apaw_practice.domain.services.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Piece;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.PiecePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PieceService {

    private PiecePersistence piecePersistence;

    @Autowired
    public PieceService(PiecePersistence piecePersistence){
        this.piecePersistence = piecePersistence;
    }

    public Piece updatePrice(String barcode, BigDecimal price){
        return piecePersistence.updatePrice(barcode, price);
    }

}
