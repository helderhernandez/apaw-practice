package es.upm.miw.apaw_practice.adapters.mongodb.shop;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ArticleEntityRepositoryIT {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testFindByBarcode() {
        ArticleEntity article = this.articleRepository.findByBarcode(84003L).get();
        assertEquals("art 003", article.getDescription());
        assertEquals(0, new BigDecimal("12.13").compareTo(article.getPrice()));
        assertEquals("prov 3", article.getProvider());
    }

}
