package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ArticleService;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ArticleResource.ARTICLES)
public class ArticleResource {
    static final String ARTICLES = "/articles";

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
}
