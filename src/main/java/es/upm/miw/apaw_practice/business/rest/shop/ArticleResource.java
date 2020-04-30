package es.upm.miw.apaw_practice.business.rest.shop;

import es.upm.miw.apaw_practice.business.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.business.services.shop.ArticleService;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(ArticleResource.ARTICLES)
public class ArticleResource {
    static final String ARTICLES = "/articles";
    static final String SEARCH = "/search";

    private ArticleService articleService;

    @Autowired
    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public Article create(@RequestBody ArticleCreationDto articleCreationDto) {
        return this.articleService.create(articleCreationDto);
    }

    @PatchMapping
    public void updatePrices(@RequestBody List<ArticlePriceUpdatingDto> articlePriceUpdatingDtoList) {
        this.articleService.updatePrices(articlePriceUpdatingDtoList);
    }

    @GetMapping(SEARCH)
    public Stream<Article> findByProviderAndPriceGreaterThan(@RequestParam String q) {
        String provider = new LexicalAnalyzer().extractAssured(q, "provider");
        BigDecimal price = new LexicalAnalyzer().extractAssured(q, "price", BigDecimal::new);
        return this.articleService.findByProviderAndPriceGreaterThan(provider, price);
    }

}
