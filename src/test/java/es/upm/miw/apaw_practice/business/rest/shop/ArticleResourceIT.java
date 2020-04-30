package es.upm.miw.apaw_practice.business.rest.shop;

import es.upm.miw.apaw_practice.business.rest.RestTestConfig;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class ArticleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testCreate() {
        Article article =
                new Article(666004L, "art rest", new BigDecimal("3.00"), null);
        this.webTestClient
                .post()
                .uri(this.contextPath + ArticleResource.ARTICLES)
                .body(BodyInserters.fromValue(article))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .value(Assertions::assertNotNull)
                .value(articleData -> assertNotNull(articleData.getId()));
    }

    @Test
    void testCreateConflict() {
        Article article =
                new Article(84001L, "repeated", new BigDecimal("3.00"), null);
        this.webTestClient
                .post()
                .uri(this.contextPath + ArticleResource.ARTICLES)
                .body(BodyInserters.fromValue(article))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testUpdatePricesNotFound() {
        List<ArticlePriceUpdatingDto> articlePriceUpdatingDtoList = Arrays.asList(
                new ArticlePriceUpdatingDto(0L, BigDecimal.ONE)
        );
        this.webTestClient
                .patch()
                .uri(this.contextPath + ArticleResource.ARTICLES)
                .body(BodyInserters.fromValue(articlePriceUpdatingDtoList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testSearchByProviderAndPriceGreaterThan() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(this.contextPath + ArticleResource.ARTICLES + ArticleResource.SEARCH)
                                .queryParam("q", "provider:prov 1;price:1.02")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Article.class)
                .value(articles -> assertTrue(articles.size() > 0))
                .value(articles -> assertEquals("prov 1", articles.get(0).getProvider()))
                .value(articles -> assertTrue(new BigDecimal("1.02").compareTo(articles.get(0).getPrice()) < 0));
    }

    @Test
    void testSearchByProviderAndPriceGreaterThanBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(this.contextPath + ArticleResource.ARTICLES + ArticleResource.SEARCH)
                                .queryParam("q", "kk:prov 1;price:1.02")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
