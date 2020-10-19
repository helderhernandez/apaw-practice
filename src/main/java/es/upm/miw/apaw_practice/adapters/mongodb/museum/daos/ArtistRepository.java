package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import org.springframework.data.mongodb.repository.MongoRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleEntity;

public interface ArtistRepository extends MongoRepository<ArticleEntity, String> {
}
