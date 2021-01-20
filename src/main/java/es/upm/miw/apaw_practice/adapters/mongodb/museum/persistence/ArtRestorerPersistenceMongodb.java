package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtRestorerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PaintRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PatronEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtRestorerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("artRestorerPersistence")
public class ArtRestorerPersistenceMongodb implements ArtRestorerPersistence {

    private ArtRestorerRepository artRestorerRepository;
    private PaintRepository paintRepository;

    @Autowired
    public ArtRestorerPersistenceMongodb(ArtRestorerRepository artRestorerRepository, PaintRepository paintRepository, ArtistRepository artistRepository) {
        this.artRestorerRepository = artRestorerRepository;
        this.paintRepository = paintRepository;
    }


    @Override
    public ArtRestorer readById(String id) {
        return this.artRestorerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ArtRestorer Id:" + id))
                .toArtRestorer();
    }

    @Override
    public ArtRestorer update(ArtRestorer artRestorer) {

        ArtRestorerEntity artRestorerEntity = this.artRestorerRepository
                .findById(artRestorer.getId())
                .orElseThrow(() -> new NotFoundException("ArtRestorer Id:" + artRestorer.getId()));

        artRestorer.setName(artRestorer.getName());
        artRestorer.setSurname(artRestorer.getSurname());
        artRestorer.setJobTitle(artRestorer.getJobTitle());

        return this.artRestorerRepository.save(artRestorerEntity).toArtRestorer();
    }

    @Override
    public Stream<String> findArtRestorerJobTitlesByArtistCountry(String artistCountry) {

        return paintRepository.findAll()
                .stream()
                .filter(paintEntity -> paintEntity.getArtistEntity().getCounty().equals(artistCountry))
                .flatMap(paintEntity -> paintEntity.getArtRestorerEntities()
                        .stream())
                .map(artRestorerEntity -> artRestorerEntity.getJobTitle());

    }
}
