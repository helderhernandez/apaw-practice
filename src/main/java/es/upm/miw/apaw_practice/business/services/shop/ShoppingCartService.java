package es.upm.miw.apaw_practice.business.services.shop;

import es.upm.miw.apaw_practice.data.daos.shop.ArticleRepository;
import es.upm.miw.apaw_practice.data.daos.shop.ShoppingCartRepository;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticleItemDto;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ShoppingCartReferenceDto;
import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import es.upm.miw.apaw_practice.data.model.entities.shop.ArticleItem;
import es.upm.miw.apaw_practice.data.model.entities.shop.ShoppingCart;
import es.upm.miw.apaw_practice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
                })
                .collect(Collectors.toList());
        shoppingCart.setArticleItems(articleItemList);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    public List<ShoppingCartReferenceDto> findByPriceGreaterThan(BigDecimal price) {
        return this.shoppingCartRepository.findAll().stream()
                .filter(shoppingCart -> price.compareTo(shoppingCart.total()) < 0)
                .map(ShoppingCartReferenceDto::new)
                .collect(Collectors.toList());
    }
}
