package es.upm.miw.apaw_practice.business.services.shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.data.daos.shop.ArticleRepository;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import es.upm.miw.apaw_practice.exceptions.NotFoundException;
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
        List<Article> oldArticles = this.articleRepository.findAll().stream()
                .filter(article -> 84002L == article.getBarcode() || 84003L == article.getBarcode())
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
        this.articleRepository.saveAll(oldArticles);
    }
}
