package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.library.BookPriceUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestTestConfig
public class BookResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateBookPriceNotfound(){
        List<BookPriceUpdating> bookPriceUpdatingList= Arrays.asList(
                new BookPriceUpdating("978711163666",new BigDecimal("12.5")));
        this.webTestClient
                .patch()
                .uri(BookResource.BOOK)
                .body(BodyInserters.fromValue(bookPriceUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateBookPriceOk(){
        List<BookPriceUpdating> bookPriceUpdatingList= Arrays.asList(
                new BookPriceUpdating("9787111636663",new BigDecimal("12.5")),
                new BookPriceUpdating("9787111636623",new BigDecimal("18.5")));
        this.webTestClient
                .patch()
                .uri(BookResource.BOOK)
                .body(BodyInserters.fromValue(bookPriceUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }
}
