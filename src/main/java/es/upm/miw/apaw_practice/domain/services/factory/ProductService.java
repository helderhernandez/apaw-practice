package es.upm.miw.apaw_practice.domain.services.factory;

import es.upm.miw.apaw_practice.domain.models.factory.Product;
import es.upm.miw.apaw_practice.domain.models.factory.ProductWholesalePriceUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final ProductPersistence productPersistence;

    @Autowired
    public ProductService(ProductPersistence productPersistence) {
        this.productPersistence = productPersistence;
    }

    public Stream<Product> readAll() {
        return this.productPersistence.readAll();
    }

    public void updateWholesalePrice(List<ProductWholesalePriceUpdate> productWholesalePriceUpdateList) {
        productWholesalePriceUpdateList.stream()
                .map(newWholesalePrice -> {
                    Product product = this.productPersistence.readBySerialNumber(newWholesalePrice.getSerialNumber());
                    product.setWholesalePrice(newWholesalePrice.getWholesalePrice());
                    return product;
                })
                .forEach(this.productPersistence::update);
    }
}

