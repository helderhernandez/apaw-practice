package es.upm.miw.apaw_practice.data.shop.daos;

import es.upm.miw.apaw_practice.data.shop.entities.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
