package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.models.museum.ArtistCountryUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ArtistService {

    private ArtistPersistence artistPersistence;

    @Autowired
    public ArtistService(ArtistPersistence artistPersistence){ this.artistPersistence = artistPersistence; }

    public Stream<Artist> readAll() { return this.artistPersistence.readAll(); }

    public void updateCounrty(ArtistCountryUpdating artistCountryUpdating){
        Artist artist = this.artistPersistence.readById(artistCountryUpdating.getId());
        artist.setCounty(artistCountryUpdating.getCountry());
        this.artistPersistence.update(artist);
    }
}
