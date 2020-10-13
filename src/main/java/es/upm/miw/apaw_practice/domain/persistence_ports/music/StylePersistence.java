package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.Style;

public interface StylePersistence {
    Style create(Style style);
    Style update(Style style);
    Style readByName(String name);
}
