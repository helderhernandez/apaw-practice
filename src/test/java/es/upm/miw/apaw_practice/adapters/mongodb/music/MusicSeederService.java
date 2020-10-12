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

                new SingerEntity("Bruno","Mars","America"),
                new SingerEntity("Luis","Fonis","Spain"),
                new SingerEntity("John","Legend","America")
        };
        this.singerRepository.saveAll(Arrays.asList(singers));

        StyleEntity[] styles = {
                new StyleEntity(new Style("POP","Pop is a genre of popular music that originated in its modern form during the mid-1950s in the United States and the United Kingdom.")),
                new StyleEntity(new Style("BLUES","Blues is a music genre and musical form which was originated in the Deep South of the United States around the 1860s by African-Americans from roots in African musical traditions.")),
                new StyleEntity(new Style("HIP HOP","Hip hop music, also known as rap music, is a genre of popular music developed in the United States by inner-city African Americans and Latino Americans in the Bronx borough of New York City in the 1970s."))

        };
        this.styleRepository.saveAll(Arrays.asList(styles));
        MusicEntity[] musics = {
                new MusicEntity(styles[0],"Fly to moon","a song of pop"),
                new MusicEntity(styles[1],"Despacito","a spanish song"),
                new MusicEntity(styles[2],"Beautiful bird","a english song")

        };
        this.musicRepository.saveAll(Arrays.asList(musics));
        AlbumEntity[] albums = {
                new AlbumEntity(Arrays.asList(singers),Arrays.asList(musics),"Fly to moon","42341251", LocalDate.of(2020,3,23),"an album of pop",new BigDecimal("19.99"),true),
                new AlbumEntity(Arrays.asList(singers),Arrays.asList(musics),"Despacito","13423451", LocalDate.of(2019,6,9),"an spanish album",new BigDecimal("29.99"),true),
                new AlbumEntity(Arrays.asList(singers),Arrays.asList(musics),"Beautiful bird","43241242", LocalDate.of(2009,6,13),"an american album",new BigDecimal("9.99"),false),
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
