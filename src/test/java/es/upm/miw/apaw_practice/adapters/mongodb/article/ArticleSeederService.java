package es.upm.miw.apaw_practice.adapters.mongodb.article;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.*;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.*;
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
                new AuthorEntity("801","Mario","Weeb"),
                new AuthorEntity("802","Juan", "Vidal"),
                new AuthorEntity("803","Luis", "Peral"),
                new AuthorEntity("804","Joaquín", "Arcángel"),
                new AuthorEntity("805","Doraemon", "Lucasio")
        };
        this.authorRepository.saveAll(Arrays.asList(authors));
        EssayEntity[] essaies = {
                new EssayEntity("9801", "Articlesgreen"),
                new EssayEntity("9802", "Articleyellow"),
                new EssayEntity("9803", "Articleblack"),
                new EssayEntity("9804", "Articlewhite"),
                new EssayEntity("9805", "Articleblue")
        };
        this.essayRepository.saveAll(Arrays.asList(essaies));
        TypeEntity[] types = {
                new TypeEntity("01", "Comedy","Make people happy"),
                new TypeEntity("02", "Tragedy","Make people sad"),
                new TypeEntity("03", "Sci-fi","Very cool"),
                new TypeEntity("04", "Educational","Benefit a lot"),
                new TypeEntity("05", "Romance","Touching love")
        };
        this.typeRepository.saveAll(Arrays.asList(types));
        WorksEntity[] works = {
                new WorksEntity("79801","Cnn","87465412",LocalDate.of(2008,10,20),"International News",new BigDecimal("20.99"), (byte) 3),
                new WorksEntity("79802","Dream of the Red Chamber","87945465",LocalDate.of(2010,8,18),"masterpiece",new BigDecimal("30.99"), (byte) 4),
                new WorksEntity("79803","Journey to the West","45848798",LocalDate.of(2013,7,26),"masterpiece",new BigDecimal("15.99"), (byte) 5),
                new WorksEntity("79804","Three Kingdoms","87458594",LocalDate.of(2003,1,30),"history",new BigDecimal("39.99"), (byte) 4),
                new WorksEntity("79804","Water Margin","84531564",LocalDate.of(2020,2,10),"masterpiece",new BigDecimal("39.99"), (byte) 4)
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
