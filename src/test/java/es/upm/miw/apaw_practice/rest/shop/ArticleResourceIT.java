package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class ArticleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testCreate(){
        Article articleDto =  new Article(666004L, "art rest", new BigDecimal("3.00"), null);
        this.webTestClient
                .post()
                .uri(this.contextPath + ArticleResource.BASE_PATH)
                .body(BodyInserters.fromValue(articleDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .value(Assertions::assertNotNull)
                .value(article -> assertNotNull(article.getId()));
    }


}
