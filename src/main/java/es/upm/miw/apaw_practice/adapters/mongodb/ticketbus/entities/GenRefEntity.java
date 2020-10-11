package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;

import java.util.UUID;

public class GenRefEntity {
    private static final int MAX_NUM = 7;

    private GenRefEntity() {
        throw new IllegalStateException("Utility class");
    }

    public static String getReferenceId(String typeEntity) {
        return typeEntity + "_" + UUID.randomUUID().toString().substring(MAX_NUM);
    }
}
