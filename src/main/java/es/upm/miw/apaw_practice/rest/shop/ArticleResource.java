package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ArticleService;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ArticleResource.BASE_PATH)
public class ArticleResource {
    static final String BASE_PATH = "/articles";

    private ArticleService articleService;

    @Autowired
    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return this.articleService.create(article);
    }

}
