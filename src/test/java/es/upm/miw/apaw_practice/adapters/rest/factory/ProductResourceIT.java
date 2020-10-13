package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.factory.Product;
import es.upm.miw.apaw_practice.domain.models.factory.ProductWholesalePriceUpdate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class ProductResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(ProductResource.PRODUCTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testUpdateWholesalePrices() {
        List<ProductWholesalePriceUpdate> productWholesalePriceUpdateList = Arrays.asList(
                new ProductWholesalePriceUpdate(20000001L, new BigDecimal("12.75")),
                new ProductWholesalePriceUpdate(40000001L, new BigDecimal("2800.95"))
        );
        this.webTestClient
                .patch()
                .uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromValue(productWholesalePriceUpdateList))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class)
                .value(Assertions::assertNotNull);
        assertEquals(new BigDecimal("12.75"), Objects.requireNonNull(this.webTestClient
                .get()
                .uri(ProductResource.PRODUCTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class)
                .returnResult()
                .getResponseBody())
                .get(2)
                .getWholesalePrice());
    }

    @Test
    void testUpdateWholesalePricesNotFound() {
        List<ProductWholesalePriceUpdate> productWholesalePriceUpdateList = Collections.singletonList(
                new ProductWholesalePriceUpdate(75757575L, new BigDecimal("756.95"))
        );
        this.webTestClient
                .patch()
                .uri(ProductResource.PRODUCTS)
                .body(BodyInserters.fromValue(productWholesalePriceUpdateList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindProductsWithAnActiveMachineAndAWholesalePriceGreaterThan() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ProductResource.PRODUCTS + ProductResource.SEARCH)
                                .queryParam("q", "wholesalePrice:50.50")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class)
                .value(products -> assertEquals(30000001L, products.get(0).getSerialNumber()))
                .value(products -> assertEquals(new BigDecimal("106.65"), products.get(0).getWholesalePrice()))
                .value(products -> assertEquals("P0004", products.get(1).getItemReference()));
    }


    @Test
    void testFindProductsWithAnActiveMachineAndAWholesalePriceGreaterThanBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ProductResource.PRODUCTS + ProductResource.SEARCH)
                                .queryParam("q", "wholesalePrice:badRequest")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
