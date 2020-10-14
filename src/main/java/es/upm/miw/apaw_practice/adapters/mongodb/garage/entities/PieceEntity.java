package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import es.upm.miw.apaw_practice.domain.models.garage.Piece;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
public class PieceEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String barcode;
    private String name;
    private Boolean inStock;
    private BigDecimal price;

    public PieceEntity() {
        //empty for framework
    }

    public PieceEntity(String barcode, String name, Boolean inStock, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.barcode = barcode;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Piece toPiece() {
        Piece piece = new Piece();
        BeanUtils.copyProperties(this, piece);
        return piece;
    }

    public void fromPiece(Piece piece) {
        BeanUtils.copyProperties(piece,this);
    }

}
