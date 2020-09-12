package es.upm.miw.apaw_practice.adapters.mongodb.shop;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArticleRepository extends MongoRepository<ArticleEntity, String> {
    Optional<ArticleEntity> findByBarcode(Long barcode);
}
