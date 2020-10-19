package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.Album;

import java.math.BigDecimal;

public interface AlbumPersistence {
    void deleteById(String id);
    BigDecimal findTotalPriceAlbumByStyleName(String name);
}
