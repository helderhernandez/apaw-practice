package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ShoppingCartService;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleItemDto;
import es.upm.miw.apaw_practice.data.shop.entities.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ShoppingCartResource.BASE_PATH)
public class ShoppingCartResource {
    static final String BASE_PATH = "/shopping-cart";
    static final String ID_ID = "/{id}";
    static final String ARTICLE_ITEMS = "/article-items";

    private ShoppingCartService shoppingCartService;

    @Autowired

    public ShoppingCartResource(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PutMapping(ShoppingCartResource.ID_ID + ShoppingCartResource.ARTICLE_ITEMS)
    public ShoppingCart update(@PathVariable String id, @RequestBody List<ArticleItemDto> articleItemDtoList) {
        return this.shoppingCartService.update(id, articleItemDtoList);
    }
}
