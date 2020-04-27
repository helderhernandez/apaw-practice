package es.upm.miw.apaw_practice.business.shop;

import es.upm.miw.apaw_practice.data.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article create(ArticleCreationDto articleCreationDto) {
        return this.articleRepository.save(articleCreationDto.toArticle());
    }
}
