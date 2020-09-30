package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class ProductEntity {

    @Id
    private String id;
    private BigDecimal wholesalePrice;
    private String description;
}
