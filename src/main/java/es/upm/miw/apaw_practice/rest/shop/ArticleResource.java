package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ArticleService;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.rest.Search;
import es.upm.miw.apaw_practice.rest.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
    public List<Article> findByProviderAndPriceGreaterThan(@RequestParam String q) {
        String provider = new Search().extract(q, "provider");
        BigDecimal price;
        try {
            price = new BigDecimal(new Search().extract(q, "price"));
        } catch (Exception e) {
            throw new BadRequestException("q incorrect price");
        }
        return this.articleService.findByProviderAndPriceGreaterThan(provider, price);
    }

}
