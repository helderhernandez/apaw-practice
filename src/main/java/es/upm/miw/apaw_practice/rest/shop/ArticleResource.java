package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ArticleService;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
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

    private String extract(String q, String key) {
        int start = q.contains(key) ? q.indexOf(key) + key.length() + 1 : -1;
        if (start == -1) {
            throw new BadRequestException("q incorrect");
        }
        int end = q.indexOf(";", start) == -1 ? q.length() : q.indexOf(";", start);
        return q.substring(start, end);
    }

    @GetMapping(SEARCH)
    public List<Article> find(@RequestParam String q) {
        String provider = this.extract(q, "provider");
        BigDecimal price;
        try {
            price = new BigDecimal(this.extract(q, "price"));
        } catch (Exception e) {
            throw new BadRequestException("q incorrect price");
        }
        return this.articleService.findByProviderAndPriceGreaterThan(provider, price);
    }

}
