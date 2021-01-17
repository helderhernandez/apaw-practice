package es.upm.miw.apaw_practice.domain.model.museum.builder;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtistBuilderTest {
    @Test
    void testArtistBuilder(){
        String artistId = "Artist_id";
        String artistName = "Artist_name";
        String artistSurname = "Artist_surname";
        String artistCountry = "Artist_country";

        Artist artist = Artist.builder().id(artistId).name(artistName).surname(artistSurname).build(artistCountry);
        assertEquals(artistId, artist.getId());
        assertEquals(artistName, artist.getName());
        assertEquals(artistSurname, artist.getSurname());
        assertEquals(artistCountry, artist.getCounty());
    }
}
