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

    Article readByBarcode(Long barcode);

    void barcodeNotExist(Long barcode);

    void barcodeExist(Long barcode);

    Stream<Article> findByProviderAndPriceGreaterThan(String provider, BigDecimal price);
}
