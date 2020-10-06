package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.factory.Product;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("productPersistence")
public class ProductPersistenceMongodb implements ProductPersistence {
    private ProductRepository productRepository;

    @Autowired
    public ProductPersistenceMongodb(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product readBySerialNumber(Long serialNumber) {
        return this.productRepository
                .findBySerialNumber(serialNumber)
                .orElseThrow(() -> new NotFoundException("Product serial number: " + serialNumber))
                .toProduct();
    }

    @Override
    public Stream<Product> readAll() {
        return this.productRepository.findAll().stream()
                .map(ProductEntity::toProduct);
    }

    @Override
    public Product update(Product product) {
        ProductEntity productEntity = this.productRepository
                .findById(product.getId())
                .orElseThrow(() -> new NotFoundException("Product id: " + product.getId()));
        productEntity.fromProduct(product);
        return this.productRepository
                .save(productEntity)
                .toProduct();
    }
}
