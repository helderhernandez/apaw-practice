package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.garage.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class PieceResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testUpdatePrice(){
        PieceDto pieceDto = new PieceDto();
        pieceDto.setPrice(BigDecimal.valueOf(50));

        this.webTestClient
                .put()
                .uri(PieceResource.PIECES + PieceResource.ID_BARCODE + PieceResource.PRICE, "2124565DF")
                .body(BodyInserters.fromValue(pieceDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Piece.class)
                .value(Assertions::assertNotNull)
                .value(pieceData -> {
                    assertEquals("Luces delanteras led", pieceData.getName());
                    assertEquals(0, BigDecimal.valueOf(50).compareTo(pieceData.getPrice()));
                    assertTrue(pieceData.getInStock());
                });
    }

}
