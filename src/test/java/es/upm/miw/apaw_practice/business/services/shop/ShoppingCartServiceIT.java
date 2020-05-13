package es.upm.miw.apaw_practice.business.services.shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.data.daos.shop.ShoppingCartRepository;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticleItemDto;
import es.upm.miw.apaw_practice.data.model.entities.shop.ArticleItem;
import es.upm.miw.apaw_practice.data.model.entities.shop.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ShoppingCartServiceIT {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    void testUpdateArticleItems() {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findAll().stream()
                .filter(cart -> "user1".equals(cart.getUser()))
                .findFirst().get();
        List<ArticleItem> articleItemArrayOld = shoppingCart.getArticleItems();
        List<ArticleItemDto> articleItemArray = Arrays.asList(
                new ArticleItemDto(84002L, 2, BigDecimal.ONE),
                new ArticleItemDto(84003L, 3, BigDecimal.TEN)
        );
        ShoppingCart newShoppingCart = this.shoppingCartService.updateArticleItems(shoppingCart.getId(), articleItemArray);
        assertEquals(2, newShoppingCart.getArticleItems().size());
        assertEquals(84002L, newShoppingCart.getArticleItems().get(0).getArticle().getBarcode());
        assertEquals(2, newShoppingCart.getArticleItems().get(0).getAmount());
        assertEquals(0, BigDecimal.ONE.compareTo(newShoppingCart.getArticleItems().get(0).getDiscount()));
        shoppingCart.setArticleItems(articleItemArrayOld);
        this.shoppingCartRepository.save(shoppingCart);
    }
}
