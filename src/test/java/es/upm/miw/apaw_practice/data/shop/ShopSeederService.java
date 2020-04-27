package es.upm.miw.apaw_practice.data.shop;

import es.upm.miw.apaw_practice.data.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.data.shop.daos.ShoppingCartRepository;
import es.upm.miw.apaw_practice.data.shop.daos.TagRepository;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.data.shop.entities.ArticleItem;
import es.upm.miw.apaw_practice.data.shop.entities.ShoppingCart;
import es.upm.miw.apaw_practice.data.shop.entities.Tag;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class ShopSeederService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private TagRepository tagRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Shop Initial Load -----------");
        Article[] articles = {
                new Article(84001L, "art 001", new BigDecimal("1.23"), "prov 1"),
                new Article(84002L, "art 002", new BigDecimal("0.27"), "prov 2"),
                new Article(84003L, "art 003", new BigDecimal("12.13"), "prov 3"),
                new Article(84004L, "art 004", new BigDecimal("4.00"), "prov 4")
        };
        this.articleRepository.saveAll(Arrays.asList(articles));
        Tag[] tags = {
                new Tag("tag1", "tag 1", Arrays.asList(articles[0], articles[1]), false),
                new Tag("tag2", "tag 2", Arrays.asList(articles[0], articles[3]), true),
                new Tag("tag3", "tag 3", Arrays.asList(articles[1]), false),
        };
        this.tagRepository.saveAll(Arrays.asList(tags));
        ArticleItem[] articleItems = {
                new ArticleItem(articles[0], 1, BigDecimal.ZERO),
                new ArticleItem(articles[1], 2, BigDecimal.TEN),
                new ArticleItem(articles[1], 3, BigDecimal.ZERO),
                new ArticleItem(articles[2], 4, BigDecimal.ONE)
        };
        ShoppingCart[] carts = {
                new ShoppingCart(Arrays.asList(articleItems[0], articleItems[1]), "user 1", "address 1"),
                new ShoppingCart(Arrays.asList(articleItems[2], articleItems[3]), "user 2", "address 2")
        };
        this.shoppingCartRepository.saveAll(Arrays.asList(carts));
    }

    public void deleteAll() {
        this.shoppingCartRepository.deleteAll();
        this.tagRepository.deleteAll();

        this.articleRepository.deleteAll();
    }

}
