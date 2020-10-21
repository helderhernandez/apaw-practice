package es.upm.miw.apaw_practice.adapters.mongodb.museum;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.*;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class MuseumSeederService {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ArtRestorerRepository artRestorerRepository;
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private PaintRepository paintRepository;
    @Autowired
    private PatronRepository patronRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Museum Initial Load -----------");
        ArtistEntity[] artists = {
                new ArtistEntity("AAA1", "Artist1", "Artist_Surname1", "Country1"),
                new ArtistEntity("AAA2", "Artist2", "Artist_Surname2", "Country2"),
                new ArtistEntity("AAA3", "Artist3", "Artist_Surname3", "Country3"),
                new ArtistEntity("AAA4", "Artist4", "Artist_Surname4", "Country4")
        };
        this.artistRepository.saveAll(Arrays.asList(artists));

        ArtRestorerEntity[] artRestorers = {
                new ArtRestorerEntity("ARR1", "ArtRestorer1", "ArtRestorer_Surname1", "Title1"),
                new ArtRestorerEntity("ARR2", "ArtRestorer2", "ArtRestorer_Surname2", "Title2"),
                new ArtRestorerEntity("ARR3", "ArtRestorer3", "ArtRestorer_Surname3", "Title3"),
                new ArtRestorerEntity("ARR4", "ArtRestorer4", "ArtRestorer_Surname4", "Title4")
        };
        this.artRestorerRepository.saveAll(Arrays.asList(artRestorers));

        PaintEntity[] paints = {
                new PaintEntity("PPP1", "Paint1", LocalDate.now(), "Technique1", true, artists[0], List.of(artRestorers[0], artRestorers[1])),
                new PaintEntity("PPP2", "Paint2", LocalDate.now(), "Technique1", false, artists[2], null),
                new PaintEntity("PPP3", "Paint3", LocalDate.now(), "Technique2", true, artists[3], List.of(artRestorers[2]))
        };
        this.paintRepository.saveAll(Arrays.asList(paints));

        PatronEntity[] patrons = {
                new PatronEntity("PAT1", paints[0], "Patron_1", "Patron_Surname1",new BigDecimal("1000.00")),
                new PatronEntity("PAT2", paints[4], "Patron_2", "Patron_Surname2",new BigDecimal("2000.00")),
        };
        this.patronRepository.saveAll(Arrays.asList(patrons));

        CollectionEntity[] collections = {
                new CollectionEntity("CCC1", "Collection_1", LocalDate.now(), 5, List.of(paints[0],paints[1])),
                new CollectionEntity("CCC2", "Collection_2", LocalDate.now(), 365, List.of(paints[2],paints[3]))
        };
        this.collectionRepository.saveAll(Arrays.asList(collections));
    }

    public void deleteAll() {
        this.artistRepository.deleteAll();
        this.artRestorerRepository.deleteAll();
        this.paintRepository.deleteAll();
        this.patronRepository.deleteAll();
        this.collectionRepository.deleteAll();
    }


}
