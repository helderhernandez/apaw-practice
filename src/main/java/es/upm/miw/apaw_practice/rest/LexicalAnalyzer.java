package es.upm.miw.apaw_practice.rest;

import es.upm.miw.apaw_practice.rest.exceptions.BadRequestException;

public class LexicalAnalyzer {

    private static final String ASSIGNMENT = ":";
    private static final Character BOOKMARK = ';';

    public String extractAssured(String q, String key) {
        if (!q.contains(key)) {
            throw new BadRequestException("q key not found: " + key);
        }
        int start = q.indexOf(key) + key.length();

        if (ASSIGNMENT.equals(q.substring(start, start + ASSIGNMENT.length()))) {
            start += ASSIGNMENT.length();
            int end = q.indexOf(BOOKMARK, start) == -1 ? q.length() : q.indexOf(BOOKMARK, start);
            return q.substring(start, end);
        } else {
            return "";
        }

    }

}
