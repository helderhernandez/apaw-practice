package es.upm.miw.apaw_practice.data.daos.shop;

import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArticleRepository extends MongoRepository<Article, String> {
    Optional<Article> findByBarcode(Long barcode);
}
