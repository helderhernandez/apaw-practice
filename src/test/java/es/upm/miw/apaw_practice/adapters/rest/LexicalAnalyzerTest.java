package es.upm.miw.apaw_practice.adapters.rest;

import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LexicalAnalyzerTest {

    @Test
    void testExtractWithAssureFirst() {
        assertEquals("ana", new LexicalAnalyzer().extractWithAssure("name:ana", "name"));
        assertEquals("ana", new LexicalAnalyzer().extractWithAssure("name:ana;surname:gil", "name"));
        assertEquals("", new LexicalAnalyzer().extractWithAssure("name", "name"));
        assertEquals("", new LexicalAnalyzer().extractWithAssure("name;surname:gil", "name"));
    }

    @Test
    void testExtractWithAssureSecond() {
        assertEquals("gil", new LexicalAnalyzer().extractWithAssure("name:ana;surname:gil", "surname"));
        assertEquals("", new LexicalAnalyzer().extractWithAssure("name:ana;surname", "surname"));
    }

    @Test
    void testExtractWithAssureBadRequest() {
        assertThrows(BadRequestException.class, () -> {
            new LexicalAnalyzer().extractWithAssure("name:ana;surname:gil", "ana");
            new LexicalAnalyzer().extractWithAssure("", "name");
            new LexicalAnalyzer().extractWithAssure("price:kk", "price", BigDecimal::new);
        });
    }

    @Test
    void testExtractWithAssureConverting() {
        BigDecimal price = new LexicalAnalyzer().extractWithAssure("price:10.12", "price", BigDecimal::new);
        assertEquals(0, new BigDecimal("10.12").compareTo(price));
    }

}
