package es.upm.miw.apaw_practice.data.daos.shop;

import es.upm.miw.apaw_practice.data.model.entities.shop.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
