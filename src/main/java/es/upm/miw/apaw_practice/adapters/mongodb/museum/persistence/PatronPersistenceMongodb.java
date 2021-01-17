package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PaintRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PatronRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PatronEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PatronPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("patronPersistence")
public class PatronPersistenceMongodb implements PatronPersistence {

    private PatronRepository patronRepository;
    private PaintRepository paintRepository;

    @Autowired
    public PatronPersistenceMongodb(PatronRepository patronRepository, PaintRepository paintRepository) {
        this.patronRepository = patronRepository;
        this.paintRepository = paintRepository;
    }

    @Override
    public Stream<String> findPatronsIDByArtistName(String artistName) {

        return this.patronRepository
                .findAll()
                .stream()
                .filter(patronEntity -> this.paintRepository
                        .findAll()
                        .stream()
                        .filter(paintEntity -> paintEntity.getArtistEntity().getName().equals(artistName))
                        .collect(Collectors.toList())
                        .contains(patronEntity.getPaintEntity()))
                .map(PatronEntity::getId);

    }
}
