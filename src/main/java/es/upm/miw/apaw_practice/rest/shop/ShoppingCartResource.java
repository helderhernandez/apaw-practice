package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.ShoppingCartService;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleItemDto;
import es.upm.miw.apaw_practice.data.shop.dtos.ShoppingCartReferenceDto;
import es.upm.miw.apaw_practice.data.shop.entities.ShoppingCart;
import es.upm.miw.apaw_practice.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.rest.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(ShoppingCartResource.SHOPPING_CARTS)
public class ShoppingCartResource {
    static final String SHOPPING_CARTS = "/shopping-carts";
    static final String ID_ID = "/{id}";
    static final String ARTICLE_ITEMS = "/article-items";
    static final String SEARCH = "/search";

    private ShoppingCartService shoppingCartService;

    @Autowired

    public ShoppingCartResource(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PutMapping(ID_ID + ARTICLE_ITEMS)
    public ShoppingCart updateArticleItems(@PathVariable String id, @RequestBody List<ArticleItemDto> articleItemDtoList) {
        return this.shoppingCartService.updateArticleItems(id, articleItemDtoList);
    }

    @GetMapping(SEARCH)
    public List<ShoppingCartReferenceDto> findByPriceGreaterThan(@RequestParam String q) {
        String priceString = new LexicalAnalyzer().extractAssured(q, "price");
        BigDecimal price;
        try {
            price = new BigDecimal(priceString);
        } catch (Exception e) {
            throw new BadRequestException("q: incorrect price: " + priceString);
        }
        return this.shoppingCartService.findByPriceGreaterThan(price);
    }
}
