package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.rest.exceptions.BadRequestException;

public class Search {
    public String extract(String q, String key) {
        int start = q.contains(key) ? q.indexOf(key) + key.length() + 1 : -1;
        if (start == -1) {
            throw new BadRequestException("q incorrect");
        }
        int end = q.indexOf(";", start) == -1 ? q.length() : q.indexOf(";", start);
        return q.substring(start, end);
    }
}
