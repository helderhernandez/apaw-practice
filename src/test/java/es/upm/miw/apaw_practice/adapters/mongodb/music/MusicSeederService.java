package es.upm.miw.apaw_practice.adapters.mongodb.music;


import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.MusicRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.SingerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.StyleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SingerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.StyleEntity;
import es.upm.miw.apaw_practice.domain.models.music.Style;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class MusicSeederService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private SingerRepository singerRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private StyleRepository styleRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Music Initial Load -----------");
        SingerEntity[] singers = {

                SingerEntity.builder("Bruno").surname("Mars").nationality("America").build(),
                SingerEntity.builder("Luis").surname("Fonis").nationality("Spain").build(),
                SingerEntity.builder("John").surname("Legend").nationality("America").build()
        };
        this.singerRepository.saveAll(Arrays.asList(singers));

        StyleEntity[] styles = {
                StyleEntity.builder("POP").description("Pop is a genre of popular music that originated in its modern form during the mid-1950s in the United States and the United Kingdom.").build(),
                StyleEntity.builder("BLUES").description("Blues is a music genre and musical form which was originated in the Deep South of the United States around the 1860s by African-Americans from roots in African musical traditions.").build(),
                StyleEntity.builder("HIP HOP").description("Hip hop music, also known as rap music, is a genre of popular music developed in the United States by inner-city African Americans and Latino Americans in the Bronx borough of New York City in the 1970s.").build()
        };
        this.styleRepository.saveAll(Arrays.asList(styles));
        MusicEntity[] musics = {
                MusicEntity.builder(styles[0],"Fly to moon").description("a song of pop").build(),
                MusicEntity.builder(styles[1],"Despacito").description("a spanish song").build(),
                MusicEntity.builder(styles[2],"Beautiful bird").description("a english song").build()

        };
        this.musicRepository.saveAll(Arrays.asList(musics));
        AlbumEntity[] albums = {
                AlbumEntity.builder(Arrays.asList(singers),Arrays.asList(musics),"Fly to moon","42341251", LocalDate.of(2020,3,23), new BigDecimal("19.99"),true).description("an album of pop").build(),
                AlbumEntity.builder(Arrays.asList(singers),Arrays.asList(musics),"Despacito","13423451", LocalDate.of(2019,12,9),new BigDecimal("29.99"),true).description("an spanish album").build(),
                AlbumEntity.builder(Arrays.asList(singers),Arrays.asList(musics),"Beautiful bird","43241242", LocalDate.of(2009,11,13),new BigDecimal("9.99"),false).description("an american album").build()
        };
        this.albumRepository.saveAll(Arrays.asList(albums));
    }
    public void deleteAll() {

        this.musicRepository.deleteAll();
        this.singerRepository.deleteAll();
        this.styleRepository.deleteAll();
        this.albumRepository.deleteAll();

    }



}
