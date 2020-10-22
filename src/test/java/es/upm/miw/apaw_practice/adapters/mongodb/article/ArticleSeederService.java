package es.upm.miw.apaw_practice.adapters.mongodb.article;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.*;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.*;
import es.upm.miw.apaw_practice.domain.models.article.Type;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class ArticleSeederService {

    @Autowired
    private EssayRepository essayRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private WorksRepository worksRepository;
    @Autowired
    private TypeRepository typeRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Article Initial Load -----------");
        AuthorEntity[] authors = {
                new AuthorEntity("Mario","Weeb","China"),
                new AuthorEntity("Juan", "Vidal","America"),
                new AuthorEntity("Luis", "Peral","Spain"),
                new AuthorEntity("Joaquín", "Arcángel","Canada"),
                new AuthorEntity("Doraemon", "Lucasio","Spain")
        };
        this.authorRepository.saveAll(Arrays.asList(authors));

        TypeEntity[] types = {
                new TypeEntity(new Type("Comedy","Make people happy")),
                new TypeEntity(new Type( "Tragedy","Make people sad")),
                new TypeEntity(new Type( "Sci-fi","Very cool")),
                new TypeEntity(new Type( "Educational","Benefit a lot")),
                new TypeEntity(new Type( "Romance","Touching love"))
        };
        this.typeRepository.saveAll(Arrays.asList(types));

        EssayEntity[] essaies = {
                new EssayEntity(types[0],"72861", "Articlesgreen"),
                new EssayEntity(types[1], "86958","Articleyellow"),
                new EssayEntity(types[2], "45896","Articleblack"),
                new EssayEntity(types[3], "78956","Articlewhite"),
                new EssayEntity(types[4], "19564","Articleblue")
        };
        this.essayRepository.saveAll(Arrays.asList(essaies));

        WorksEntity[] works = {
                new WorksEntity(Arrays.asList(authors),Arrays.asList(essaies),"Cnn",(long)87465412,LocalDate.of(2008,10,20),"International News",new BigDecimal("10.99"), (byte) 3),
                new WorksEntity(Arrays.asList(authors),Arrays.asList(essaies),"Dream of the Red Chamber",(long)87945465,LocalDate.of(2010,8,18),"masterpiece",new BigDecimal("10.99"), (byte) 4),
                new WorksEntity(Arrays.asList(authors),Arrays.asList(essaies),"Journey to the West",(long)45848798,LocalDate.of(2013,7,26),"masterpiece",new BigDecimal("15.99"), (byte) 5),
                new WorksEntity(Arrays.asList(authors),Arrays.asList(essaies),"Three Kingdoms",(long)874585,LocalDate.of(2003,1,30),"history",new BigDecimal("19.99"), (byte) 4),
                new WorksEntity(Arrays.asList(authors),Arrays.asList(essaies),"Water Margin",(long)84531564,LocalDate.of(2020,2,10),"masterpiece",new BigDecimal("19.99"), (byte) 4)
        };
        this.worksRepository.saveAll(Arrays.asList(works));
    }

    public void deleteAll() {
        this.essayRepository.deleteAll();
        this.authorRepository.deleteAll();
        this.typeRepository.deleteAll();
        this.worksRepository.deleteAll();
    }
}
