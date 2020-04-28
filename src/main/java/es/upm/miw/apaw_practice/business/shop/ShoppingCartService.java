package es.upm.miw.apaw_practice.business.shop;

import es.upm.miw.apaw_practice.data.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.data.shop.daos.ShoppingCartRepository;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleItemDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.data.shop.entities.ArticleItem;
import es.upm.miw.apaw_practice.data.shop.entities.ShoppingCart;
import es.upm.miw.apaw_practice.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ArticleRepository articleRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.articleRepository = articleRepository;
    }

    public ShoppingCart updateArticleItems(String id, List<ArticleItemDto> articleItemDtoList) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ShoppingCart id: " + id));
        List<ArticleItem> articleItemList = articleItemDtoList.stream()
                .map(articleItemDto -> {
                    Article article = this.articleRepository.findByBarcode(articleItemDto.getBarcode())
                            .orElseThrow(() -> new NotFoundException("Article barcode: " + articleItemDto.getBarcode()));
                    return new ArticleItem(article, articleItemDto.getAmount(), articleItemDto.getDiscount());
                }).collect(Collectors.toList());
        shoppingCart.setArticleItems(articleItemList);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
