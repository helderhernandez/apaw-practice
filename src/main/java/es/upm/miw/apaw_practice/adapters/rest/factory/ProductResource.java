package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.factory.Product;
import es.upm.miw.apaw_practice.domain.models.factory.ProductWholesalePriceUpdate;
import es.upm.miw.apaw_practice.domain.services.factory.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(ProductResource.PRODUCTS)

public class ProductResource {
    static final String PRODUCTS = "/factory/products";
    static final String SEARCH = "/search";


    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Stream<Product> readAll() {
        return this.productService.readAll();
    }

    @PatchMapping
    public void updateWholesalePrice(@RequestBody List<ProductWholesalePriceUpdate> productWholesalePriceUpdateList) {
        this.productService.updateWholesalePrice(productWholesalePriceUpdateList);
    }

    @GetMapping(SEARCH)
    public Stream<Product> findProductsWithAnActiveMachineAndAWholesalePriceGreaterThan(@RequestParam String q) {
        BigDecimal wholesalePrice = new LexicalAnalyzer().extractWithAssure(q, "wholesalePrice", BigDecimal::new);
        return this.productService.findProductsWithAnActiveMachineAndAWholesalePriceGreaterThan(wholesalePrice);
    }
}
