package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Piece;
import es.upm.miw.apaw_practice.domain.services.garage.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PieceResource.PIECES)
public class PieceResource {
    static final String PIECES = "/garage/pieces";
    static final String ID_BARCODE = "/{barcode}";
    static final String PRICE = "/price";

    private PieceService pieceService;

    @Autowired
    public PieceResource(PieceService pieceService){
        this.pieceService = pieceService;
    }

    @PutMapping(ID_BARCODE + PRICE)
    public Piece updatePrice(@PathVariable String barcode, @RequestBody PieceDto pieceDto){
        return this.pieceService.updatePrice(barcode, pieceDto.getPrice());
    }

}
