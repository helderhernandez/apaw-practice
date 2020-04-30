package es.upm.miw.apaw_practice.data.daos.shop;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArticleRepositoryIT {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.articleRepository.findAll().stream()
                .anyMatch(article -> 84003L == article.getBarcode() &&
                        "art 003".equals(article.getDescription()) &&
                        0 == new BigDecimal("12.13").compareTo(article.getPrice()) &&
                        "prov 3".equals(article.getProvider())
                ));
    }
}
