package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtRestorerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtRestorerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("artRestorerPersistence")
public class ArtRestorerPersistenceMongodb implements ArtRestorerPersistence {

    private ArtRestorerRepository artRestorerRepository;

    @Autowired
    public ArtRestorerPersistenceMongodb(ArtRestorerRepository artRestorerRepository) {
        this.artRestorerRepository = artRestorerRepository;
    }


    @Override
    public ArtRestorer readById(String id) {
        return this.artRestorerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ArtRestorer Id:"+id))
                .toArtRestorer();
    }

    @Override
    public ArtRestorer update(ArtRestorer artRestorer) {

        ArtRestorerEntity artRestorerEntity = this.artRestorerRepository
                .findById(artRestorer.getId())
                .orElseThrow(() -> new NotFoundException("ArtRestorer Id:"+artRestorer.getId()));

        artRestorer.setName(artRestorer.getName());
        artRestorer.setSurname(artRestorer.getSurname());
        artRestorer.setJobTitle(artRestorer.getJobTitle());

        return this.artRestorerRepository.save(artRestorerEntity).toArtRestorer() ;
    }
}
