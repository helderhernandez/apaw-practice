package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import es.upm.miw.apaw_practice.domain.models.factory.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class ProductEntity {

    @Id
    private String id;
    private String itemReference;
    @Indexed(unique = true)
    private Long serialNumber;
    private BigDecimal wholesalePrice;

    public ProductEntity() {
        // empty for framework
    }

    public ProductEntity(String itemReference, Long serialNumber, BigDecimal wholesalePrice) {
        this.itemReference = itemReference;
        this.serialNumber = serialNumber;
        this.wholesalePrice = wholesalePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemReference() {
        return itemReference;
    }

    public void setItemReference(String itemReference) {
        this.itemReference = itemReference;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (serialNumber.equals(((ProductEntity) obj).serialNumber));
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", itemReference='" + itemReference + '\'' +
                ", serialNumber=" + serialNumber +
                ", wholesalePrice=" + wholesalePrice +
                '}';
    }

    public Product toProduct() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}
