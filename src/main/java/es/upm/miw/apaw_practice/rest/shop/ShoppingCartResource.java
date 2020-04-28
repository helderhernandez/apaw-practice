package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ShoppingCartService;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleItemDto;
import es.upm.miw.apaw_practice.data.shop.entities.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ShoppingCartResource.SHOPPING_CARTS)
public class ShoppingCartResource {
    static final String SHOPPING_CARTS = "/shopping-carts";
    static final String ID_ID = "/{id}";
    static final String ARTICLE_ITEMS = "/article-items";

    private ShoppingCartService shoppingCartService;

    @Autowired

    public ShoppingCartResource(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PutMapping(ShoppingCartResource.ID_ID + ShoppingCartResource.ARTICLE_ITEMS)
    public ShoppingCart updateArticleItems(@PathVariable String id, @RequestBody List<ArticleItemDto> articleItemDtoList) {
        return this.shoppingCartService.updateArticleItems(id, articleItemDtoList);
    }
}
