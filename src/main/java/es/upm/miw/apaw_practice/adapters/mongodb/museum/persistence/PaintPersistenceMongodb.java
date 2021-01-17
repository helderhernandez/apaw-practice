package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtRestorerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PaintRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PaintPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("paintPersistence")
public class PaintPersistenceMongodb implements PaintPersistence {

    private PaintRepository paintRepository;
    private ArtRestorerRepository artRestorerRepository;

    @Autowired
    public PaintPersistenceMongodb(PaintRepository paintRepository, ArtRestorerRepository artRestorerRepository) {
        this.paintRepository = paintRepository;
        this.artRestorerRepository = artRestorerRepository;
    }

    @Override
    public Paint create(Paint paint) {
        return this.paintRepository
                .save(new PaintEntity(paint))
                .toPaint();
    }

    @Override
    public void deleteById(String id) {
        this.paintRepository.deleteById(id);
    }

    @Override
    public Stream<Paint> findPaintCollectionByArtRestorerSurname(String artRestorerSurname) {
        return this.paintRepository.findAll()
                .stream()
                .filter(paintEntity -> paintEntity.getArtRestorerEntities()
                        .stream()
                        .map(ArtRestorerEntity::getSurname)
                        .anyMatch(s -> s.equals(artRestorerSurname)))
                .map(PaintEntity::toPaint);



    }
}
