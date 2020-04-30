package es.upm.miw.apaw_practice.business.services.shop;

import es.upm.miw.apaw_practice.data.daos.shop.ArticleRepository;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticlePriceUpdatingDto;
import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import es.upm.miw.apaw_practice.exceptions.ConflictException;
import es.upm.miw.apaw_practice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                    throw new ConflictException("Barcode exist: " + article.getBarcode());
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
                })
                .collect(Collectors.toList());
        this.articleRepository.saveAll(articles);
    }

    public Stream<Article> findByProviderAndPriceGreaterThan(String provider, BigDecimal price) {
        return this.articleRepository.findAll().stream()
                .filter(article -> provider.equals(article.getProvider()))
                .filter(article -> price.compareTo(article.getPrice()) < 0);
    }
}
