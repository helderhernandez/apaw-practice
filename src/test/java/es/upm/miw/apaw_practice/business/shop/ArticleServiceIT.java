package es.upm.miw.apaw_practice.business.shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.data.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.rest.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ArticleServiceIT {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    @Test
    void testUpdatePrices() {
        List<ArticlePriceUpdatingDto> articlePriceUpdatingDtoList = Arrays.asList(
                new ArticlePriceUpdatingDto(84002L, BigDecimal.ONE),
                new ArticlePriceUpdatingDto(84003L, BigDecimal.TEN)
        );
        List<Article> articles = this.articleRepository.findAll().stream()
                .filter(article -> 84002L == article.getBarcode() || 84002L == article.getBarcode())
                .collect(Collectors.toList());
        this.articleService.updatePrices(articlePriceUpdatingDtoList);
        BigDecimal price = this.articleRepository.findByBarcode(84002L)
                .orElseThrow(() -> new NotFoundException("Article barcode"))
                .getPrice();
        assertEquals(0, BigDecimal.ONE.compareTo(price));
        price = this.articleRepository.findByBarcode(84003L)
                .orElseThrow(() -> new NotFoundException("Article barcode"))
                .getPrice();
        assertEquals(0, BigDecimal.TEN.compareTo(price));
        this.articleRepository.saveAll(articles);
    }
}
