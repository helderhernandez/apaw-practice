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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ShoppingCartServiceIT {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    void testUpdateArticleItems() {
        Optional<ShoppingCart> shoppingCartOptional = this.shoppingCartRepository.findAll().stream()
                .filter(shoppingCart -> "user1".equals(shoppingCart.getUser()))
                .findFirst();
        assertTrue(shoppingCartOptional.isPresent());
        List<ArticleItem> articleItemArrayOld = shoppingCartOptional.get().getArticleItems();
        List<ArticleItemDto> articleItemArray = Arrays.asList(
                new ArticleItemDto(84002L, 2, BigDecimal.ONE),
                new ArticleItemDto(84003L, 3, BigDecimal.TEN)
        );
        ShoppingCart newShoppingCart = this.shoppingCartService.updateArticleItems(shoppingCartOptional.get().getId(), articleItemArray);
        assertEquals(2, newShoppingCart.getArticleItems().size());
        assertEquals(84002L, newShoppingCart.getArticleItems().get(0).getArticle().getBarcode());
        assertEquals(2, newShoppingCart.getArticleItems().get(0).getAmount());
        assertEquals(0, BigDecimal.ONE.compareTo(newShoppingCart.getArticleItems().get(0).getDiscount()));
        shoppingCartOptional.get().setArticleItems(articleItemArrayOld);
        this.shoppingCartRepository.save(shoppingCartOptional.get());
    }
}
