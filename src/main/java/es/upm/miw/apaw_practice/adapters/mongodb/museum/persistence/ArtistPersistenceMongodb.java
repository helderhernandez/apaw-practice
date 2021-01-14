package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("artistPersistence")
public class ArtistPersistenceMongodb implements ArtistPersistence {

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistPersistenceMongodb(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Stream<Artist> readAll() {
        return this.artistRepository.findAll().stream()
                .map(ArtistEntity::toArtist);
    }

    @Override
    public Artist readById(String id) {
        return this.artistRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Artist id: " + id))
                .toArtist();
    }

    @Override
    public Artist update(Artist artist) {
        ArtistEntity artistEntity = this.artistRepository
                .findById(artist.getId())
                .orElseThrow(() -> new NotFoundException("Artist id: " + artist.getId()));
        artistEntity.fromArtist(artist);
        return this.artistRepository
                .save(artistEntity)
                .toArtist();
    }
}
