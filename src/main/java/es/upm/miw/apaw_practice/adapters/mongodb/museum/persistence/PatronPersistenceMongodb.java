package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PaintRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PatronRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PatronEntity;
import es.upm.miw.apaw_practice.adapters.rest.museum.PaintResource;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PatronPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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

        List<PaintEntity> paintEntities = this.paintRepository
                .findAll()
                .stream()
                .filter(paintEntity -> paintEntity.getArtistEntity().getName().equals(artistName))
                .collect(Collectors.toList());

        return this.patronRepository
                .findAll()
                .stream()
                .filter(patronEntity -> paintEntities.contains(patronEntity.getPaintEntity()))
                .map(PatronEntity::getId);

    }
}
