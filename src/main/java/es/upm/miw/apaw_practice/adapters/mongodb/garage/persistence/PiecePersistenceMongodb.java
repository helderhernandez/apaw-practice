package es.upm.miw.apaw_practice.adapters.mongodb.garage.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.PieceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.PieceEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.garage.Piece;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.PiecePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository("piecePersistence")
public class PiecePersistenceMongodb implements PiecePersistence {

    private PieceRepository pieceRepository;

    @Autowired
    public PiecePersistenceMongodb(PieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }

    @Override
    public Piece updatePrice(String barcode, BigDecimal price) {
        PieceEntity pieceEntity = this.pieceRepository.findByBarcode(barcode)
                .orElseThrow(() -> new NotFoundException("Piece barcode: " + barcode));
        pieceEntity.setPrice(price);
        return this.pieceRepository.save(pieceEntity).toPiece();
    }

}
