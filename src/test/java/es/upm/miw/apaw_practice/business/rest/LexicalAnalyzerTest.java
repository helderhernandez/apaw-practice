package es.upm.miw.apaw_practice.business.rest;

import es.upm.miw.apaw_practice.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LexicalAnalyzerTest {

    @Test
    void testExtractAssuredFirst() {
        assertEquals("ana", new LexicalAnalyzer().extractAssured("name:ana", "name"));
        assertEquals("ana", new LexicalAnalyzer().extractAssured("name:ana;surname:gil", "name"));
        assertEquals("", new LexicalAnalyzer().extractAssured("name", "name"));
        assertEquals("", new LexicalAnalyzer().extractAssured("name;surname:gil", "name"));
    }

    @Test
    void testExtractAssuredSecond() {
        assertEquals("gil", new LexicalAnalyzer().extractAssured("name:ana;surname:gil", "surname"));
        assertEquals("", new LexicalAnalyzer().extractAssured("name:ana;surname", "surname"));
    }

    @Test
    void testExtractAssuredBadRequestKeyNotFound() {
        assertThrows(BadRequestException.class, () ->
                new LexicalAnalyzer().extractAssured("name:ana;surname:gil", "ana"));
    }

    @Test
    void testExtractAssuredBadRequestEmpty() {
        assertThrows(BadRequestException.class, () ->
                new LexicalAnalyzer().extractAssured("", "name"));
    }
}
