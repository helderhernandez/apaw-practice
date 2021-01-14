package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PaintRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PaintPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("paintPersistence")
public class PaintPersistenceMongodb implements PaintPersistence {

    private PaintRepository paintRepository;

    @Autowired
    public PaintPersistenceMongodb (PaintRepository paintRepository) {
        this.paintRepository = paintRepository;
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
}
