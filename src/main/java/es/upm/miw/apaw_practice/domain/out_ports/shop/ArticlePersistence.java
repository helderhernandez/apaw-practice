package es.upm.miw.apaw_practice.domain.out_ports.shop;

import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository
public interface ArticlePersistence {

    Stream<Article> readAll();

    Article create(Article article);

    Article update(Article article);

    Article readByBarcodeAssure(Long barcode);

    void assertBarcodeNotExist(Long barcode);

    Stream<Article> findByProviderAndPriceGreaterThan(String provider, BigDecimal price);
}
