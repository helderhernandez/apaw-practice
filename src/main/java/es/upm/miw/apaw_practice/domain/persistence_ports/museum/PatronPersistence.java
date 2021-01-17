package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PatronPersistence {

    Stream<String> findPatronsIDByArtistName(String artistName);
}
