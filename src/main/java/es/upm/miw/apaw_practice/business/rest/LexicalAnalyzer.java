package es.upm.miw.apaw_practice.business.rest;

import es.upm.miw.apaw_practice.exceptions.BadRequestException;

import java.util.stream.Stream;

public class LexicalAnalyzer {

    private static final String ASSIGNMENT = ":";
    private static final String BOOKMARK = ";";

    public String extractAssured(String q, String key) {
        String[] token = Stream.of(q.split(BOOKMARK))
                .filter(item -> item.startsWith(key))
                .map(item -> item.split(ASSIGNMENT))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Key not found: " + key));
        return token.length > 1 ? token[1] : "";
    }

}
