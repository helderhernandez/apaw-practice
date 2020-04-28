package es.upm.miw.apaw_practice.business.shop;

import es.upm.miw.apaw_practice.data.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.rest.exceptions.ConflictException;
import es.upm.miw.apaw_practice.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article create(ArticleCreationDto articleCreationDto) {
        this.articleRepository.findByBarcode(articleCreationDto.getBarcode())
                .ifPresent(article -> {
                    throw new ConflictException("Barcode exist: " + articleCreationDto.getBarcode());
                });
        return this.articleRepository.save(articleCreationDto.toArticle());
    }

    public void updatePrices(List<ArticlePriceUpdatingDto> articlePriceUpdatingDtoList) {
        List<Article> articles = articlePriceUpdatingDtoList.stream()
                .map(articleNewPrice -> {
                    Article article = this.articleRepository.findByBarcode(articleNewPrice.getBarcode())
                            .orElseThrow(() -> new NotFoundException("Article barcode: " + articleNewPrice.getBarcode()));
                    article.setPrice(articleNewPrice.getPrice());
                    return article;
                }).collect(Collectors.toList());
        this.articleRepository.saveAll(articles);
    }

    public List<Article> findByProviderAndPriceGreaterThan(String provider, BigDecimal price) {
        return this.articleRepository.findAll().stream()
                .filter(article -> provider.equals(article.getProvider()))
                .filter(article -> price.compareTo(article.getPrice()) < 0)
                .collect(Collectors.toList());
    }
}
