package es.upm.miw.apaw_practice.domain.services.article;

import es.upm.miw.apaw_practice.domain.models.article.Essay;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.EssayPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class EssayService {
    private final EssayPersistence essayPersistence;

    @Autowired
    public EssayService(EssayPersistence essayPersistence) { this.essayPersistence = essayPersistence; }

    public Essay updateName(String id, String name) { return this.essayPersistence.updateName(id, name); }

    public Stream<Essay>findEssayIdByAuthor(String nationality){return this.essayPersistence.findEssayIdByAuthor(nationality);}
}
